package com.UserChecker.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.UserChecker.Entity.User;
import com.UserChecker.Entity.UserDto;
import com.UserChecker.Repositary.UserRepo;
import com.UserChecker.Service.EmailService;
import com.UserChecker.Service.UserComparisonService;
import com.UserChecker.Service.UserService;


@RestController
@RequestMapping("/api/checker")
public class UserCheckerController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserComparisonService userComparisonService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserRepo userRepo;
	

	@GetMapping("/finduser")
	public ResponseEntity<?> getUserHaveingCELLAndPhone(@RequestParam String cell,@RequestParam String phone){
		if(this.userRepo.existsByPhoneAndCell(phone, cell)) {
			User user=this.userRepo.findByCellAndPhone(cell, phone);
			return new ResponseEntity<User>(user,HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> getUser(@RequestParam long from,@RequestParam long to){
		List<UserDto> Users=this.userService.getUserFromUserIdTOUserId(from, to);
		
		if(!Users.isEmpty()) {
			return new ResponseEntity<>(Users,HttpStatus.OK);
		}
		return ResponseEntity.ok("No Users Found from index :-> "+from +" to index :-> "+to);
		
	}

    @PostMapping("/diff")
    public ResponseEntity<String>checkDifference(@RequestBody List<User>users){
    	System.out.print("chla");
    	User olduser=users.get(0);
    	User newuser=users.get(1);
    	
    	Map<String,String> difference=userComparisonService.compareUsers(olduser, newuser);
    	
    	String output=userComparisonService.generateHtmlFromDifferences(difference);
    	
    	emailService.sendEmailHtmlContent("20cs1001@mvn.edu.in", "Test sending function", output);
    	
		return ResponseEntity.ok().header("Content-Type", "text/html").body(userComparisonService.generateHtmlFromDifferences(difference));

    }

}
