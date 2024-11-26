package com.UserChecker.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.UserChecker.Entity.User;
import com.UserChecker.Entity.UserDto;
import com.UserChecker.Repositary.UserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserComparisonService userComparisonService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private Logger logger=LoggerFactory.getLogger(UserService.class);
		
	private final RestTemplate restTemplate;
	
	
	public UserService() {
		super();
		this.restTemplate = new RestTemplate();	
	}

	public List<UserDto> getUserFromUserIdTOUserId(long from,long to){
		List<User> getUsers=this.userRepo.findByUserIdBetween(from, to);
		List<UserDto> userDtos = getUsers.stream().map(user -> this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		logger.info("getting users");
		return userDtos;
	}
	
	 @Scheduled(fixedRate = 100000)
	public void fetchAndStoreUsers() {
		System.out.println("Running scheduled task to fetch users from API...");
		
		try {
			
			// Call the API to get user data
            String apiUrl = "https://randomuser.me/api/"; // Fetch 10 users at a time
            
	        // Fetch the response as a Map
	        ResponseEntity<Map> response = restTemplate.getForEntity("https://randomuser.me/api/", Map.class);
	        
	        // Extract the "results" key, which contains a list of user data
	        List<Map<String, Object>> results = (List<Map<String, Object>>) response.getBody().get("results");

            if (response != null && results!= null) {
            	
                // Get the first user data (the first element in the results list)
    	        Map<String, Object> userData = results.get(0);
    	        
    	        // Use ObjectMapper to map the user data (Map) to UserDto
    	        ObjectMapper objectMapper = new ObjectMapper();
    	        UserDto userDto = objectMapper.convertValue(userData, UserDto.class);
    	        
    	        
                    // Save to database if not already present
                    if (!this.userRepo.existsByPhoneAndCell(userDto.getPhone(), userDto.getCell())) {
                    	
                      	  User user=this.userRepo.save(this.UserDtoTOUserConverter(userDto));
                           System.out.println("User is sussfully save " + user.toString());
                           
                    } else {
                    	User OldUser=this.userRepo.findByCellAndPhone(userDto.getPhone(), userDto.getCell());
                    	
                    	User newUser=this.UserDtoTOUserConverter(userDto);
                    	
                    	Map<String,String> difference=userComparisonService.compareUsers(OldUser, newUser);
                    	
                    	String output=userComparisonService.generateHtmlFromDifferences(difference);
                    	
                    	this.emailService.sendEmailHtmlContent(newUser.getEmail(), "Updated Details Information", output);
                    	
                    	this.userRepo.save(OldUser);
                    	
                    	System.out.println("Email is sent ");
                    }
                }else {
                	throw new RuntimeException("response must be null");
                	
                }
                       
		}catch (Exception e) {
			System.err.println("Error fetching users: " + e.getMessage());
		}
	}
	 
	 
	 public User UserDtoTOUserConverter(UserDto userDto) {
		 User user=new User();
		 user.setJsoId(userDto.getId());
		 user.setLocation(userDto.getLocation());
		 user.setCell(userDto.getCell());
		 user.setDob(userDto.getDob());
		 user.setEmail(userDto.getEmail());
		 user.setGender(userDto.getGender());
		 user.setLocation(userDto.getLocation());
		 user.setLogin(userDto.getLogin());
		 user.setName(userDto.getName());
		 user.setNat(userDto.getNat());
		 user.setPhone(userDto.getPhone());
		 user.setPicture(userDto.getPicture());
		 user.setRegistered(userDto.getRegistered());
		return user;
		 
	 }
}
