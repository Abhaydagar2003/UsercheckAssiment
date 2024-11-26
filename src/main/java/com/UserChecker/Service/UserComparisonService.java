package com.UserChecker.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.eclipse.angus.mail.imap.OlderTerm;
import org.springframework.stereotype.Service;

import com.UserChecker.Entity.Coordinates;
import com.UserChecker.Entity.DateOfBirth;
import com.UserChecker.Entity.JsoId;
import com.UserChecker.Entity.Location;
import com.UserChecker.Entity.Login;
import com.UserChecker.Entity.Name;
import com.UserChecker.Entity.Picture;
import com.UserChecker.Entity.Registration;
import com.UserChecker.Entity.Street;
import com.UserChecker.Entity.Timezone;
import com.UserChecker.Entity.User;

@Service
public class UserComparisonService {

	
	public Map<String, String> compareUsers(User oldUser, User newUser) {
	    Map<String, String> differences = new HashMap<>();

	    // Compare each field
	    if (!Objects.equals(oldUser.getGender(), newUser.getGender())) {
	        differences.put("gender", "Old: " + oldUser.getGender() + ", New: " + newUser.getGender());
	        oldUser.setGender(newUser.getGender());
	    }
	    
        //Name
	    if (!Objects.equals(oldUser.getName(), newUser.getName())) {
	       oldUser.setName(this.handleName(differences, oldUser.getName(), newUser.getName()));
	    }
	    
	    //location
	    if (!Objects.equals(oldUser.getLocation(), newUser.getLocation())) {
	    	oldUser.setLocation(this.handleLocation(differences, oldUser.getLocation(), newUser.getLocation()));
	    }


	    if (!Objects.equals(oldUser.getEmail(), newUser.getEmail())) {
	        differences.put("email", "Old: " + oldUser.getEmail() + ", New: " + newUser.getEmail());
	        oldUser.setEmail(newUser.getEmail());
	    }
	    
// handle login
	    if (!Objects.equals(oldUser.getLogin(), newUser.getLogin())) {
	    	oldUser.setLogin(this.handleLogin(differences, oldUser.getLogin(), newUser.getLogin()));
	    }
	    	
      //date-of-birth
	    if (!Objects.equals(oldUser.getDob(), newUser.getDob())) {
	    	oldUser.setDob(this.handleDateOfBirth(differences, oldUser.getDob(), newUser.getDob()));
	    }

	    //handel registration
	    if (!Objects.equals(oldUser.getRegistered(), newUser.getRegistered())) {
	    	oldUser.setRegistered(this.handleRegistration(differences, oldUser.getRegistered(), newUser.getRegistered()));
	    }

	    if (!Objects.equals(oldUser.getPhone(), newUser.getPhone())) {
	        differences.put("phone", "Old: " + oldUser.getPhone() + ", New: " + newUser.getPhone());
	        oldUser.setPhone(newUser.getPhone());
	    }

	    if (!Objects.equals(oldUser.getCell(), newUser.getCell())) {
	        differences.put("cell", "Old: " + oldUser.getCell() + ", New: " + newUser.getCell());
	        oldUser.setCell(newUser.getCell());
	    }
// handle picture
	    if (!Objects.equals(oldUser.getPicture(), newUser.getPicture())) {
	    	oldUser.setPicture(this.handlePicture(differences, oldUser.getPicture(), newUser.getPicture()));
	    }

	    if (!Objects.equals(oldUser.getNat(), newUser.getNat())) {
	        differences.put("nat", "Old: " + oldUser.getNat() + ", New: " + newUser.getNat());
	        oldUser.setNat(newUser.getNat());
	    }

	    if (!Objects.equals(oldUser.getJsoId(), newUser.getJsoId())) {
	    	oldUser.setJsoId(this.handleJsonId(differences, oldUser.getJsoId(), newUser.getJsoId()));
	    }
	    
	    return differences;
	}
	
	private JsoId handleJsonId(Map<String, String>differences,JsoId oldJsoIdObj,JsoId newJsoIdObj) {
		StringBuilder newJsonId=new StringBuilder();
    	StringBuilder oldJsonId=new StringBuilder();
    	
    	if(!oldJsoIdObj.getName().equals(newJsoIdObj.getName())){
    		oldJsonId.append("Name :-> "+oldJsoIdObj.getName()+"<br>");
    		newJsonId.append("Name :-> "+newJsoIdObj.getName()+"<br>");
    	}
    	
    	if(!oldJsoIdObj.getValue().equals(newJsoIdObj.getValue())){
    		oldJsonId.append("value :-> "+oldJsoIdObj.getValue()+"<br>");
    		newJsonId.append("value :-> "+newJsoIdObj.getValue()+"<br>");
    	}
    	
        differences.put("jsoId", "Old: " + oldJsonId + ", New: " + newJsonId);
        
        return newJsoIdObj;
	}
	
	private Picture handlePicture(Map<String, String>differences,Picture oldPictureObj,Picture newPictureObj) {
		StringBuilder newPicture=new StringBuilder();
    	StringBuilder oldPicture=new StringBuilder();
    	
    	if(!oldPictureObj.getLarge().equals(newPictureObj.getLarge())) {
    		oldPicture.append("Large :-> "+oldPictureObj.getLarge()+"<br>");
    		newPicture.append("Large :-> "+newPictureObj.getLarge()+"<br>");
    	}
    	if(!oldPictureObj.getMedium().equals(newPictureObj.getMedium())) {
    		oldPicture.append("Medium :-> "+oldPictureObj.getMedium()+"<br>");
    		newPicture.append("Medium :-> "+newPictureObj.getMedium()+"<br>");
    	}
    	if(!oldPictureObj.getThumbnail().equals(newPictureObj.getThumbnail())) {
    		oldPicture.append("Thumbnail :-> "+oldPictureObj.getThumbnail()+"<br>");
    		newPicture.append("Thumbnail :-> "+newPictureObj.getThumbnail()+"<br>");
    	}
    	
        differences.put("picture", "Old: " + oldPicture + ", New: " + newPicture);
        
        return newPictureObj;
	}
	
	private Registration handleRegistration(Map<String, String>differences,Registration oldRegistrationObj,Registration newRegistrationObj) {
		StringBuilder newRegistered=new StringBuilder();
    	StringBuilder oldRegistered=new StringBuilder();
    	
    	if(oldRegistrationObj.getAge()!=newRegistrationObj.getAge()) {
    		oldRegistered.append("Registered-Age :-> "+oldRegistrationObj.getAge()+"<br>");
    		newRegistered.append("Registered-Age :-> "+newRegistrationObj.getAge()+"<br>");
    	}
    	
    	if(!oldRegistrationObj.getDate().equals(newRegistrationObj.getDate())) {
    		oldRegistered.append("Registered-Date :-> "+oldRegistrationObj.getDate()+"<br>");
    		newRegistered.append("Registered-Date :-> "+newRegistrationObj.getDate()+"<br>");
    	}
    	
        differences.put("registered", "Old: " + oldRegistered + ", New: " + newRegistered);
        
        return newRegistrationObj;
	}
	
	private DateOfBirth handleDateOfBirth(Map<String, String>differences,DateOfBirth oldDateOfBirthObj,DateOfBirth newDateOfBirthObj) {
    	StringBuilder newDateOfBirth=new StringBuilder();
    	StringBuilder oldDateOfBirth=new StringBuilder();
    	
    	if(!oldDateOfBirthObj.getDate().equals(newDateOfBirthObj.getDate())) {
    		oldDateOfBirth.append("Date-Of-Birth :-> "+oldDateOfBirthObj.getDate()+"<br>");
    		newDateOfBirth.append("Date-Of-Birth :-> "+newDateOfBirthObj.getDate()+"<br>");
    	}
    	
    	if(oldDateOfBirthObj.getAge()!=newDateOfBirthObj.getAge()) {
    		oldDateOfBirth.append("Age :-> "+oldDateOfBirthObj.getAge()+"<br>");
    		newDateOfBirth.append("Age :-> "+newDateOfBirthObj.getAge()+"<br>");
    	}
    	
        differences.put("dob", "Old: " + oldDateOfBirth + ", New: " + newDateOfBirth);
        
        return newDateOfBirthObj;
	}

	
	private Name handleName(Map<String, String>differences,Name oldNameObj,Name newNameObj) {
		StringBuilder newname=new StringBuilder();
    	StringBuilder oldname=new StringBuilder();
    	
    	if(!oldNameObj.getFirst().equals(newNameObj.getFirst())) {
    		oldname.append("First-Name :-> "+oldNameObj.getFirst()+"<br>");
    		newname.append("First-Name :-> "+newNameObj.getFirst()+"<br>");
    	}
    	
        if(!oldNameObj.getLast().equals(newNameObj.getLast())) {
        	oldname.append("Last-Name :-> "+oldNameObj.getLast()+"<br>");
    		newname.append("Last-Name :-> "+newNameObj.getLast()+"<br>");
    	}
        
        if(!oldNameObj.getTitle().equals(newNameObj.getTitle())) {
        	oldname.append("Title-Name :-> "+oldNameObj.getTitle()+"<br>");
    		newname.append("Title-Name :-> "+newNameObj.getTitle()+"<br>");
        }
        
        differences.put("name", "Old: " + oldname + ", New: " + newname);
        
        return newNameObj;
	}
	
	
	private Login handleLogin(Map<String, String>differences,Login oldLoginObj,Login newLoginObj) {
    	StringBuilder newlogin=new StringBuilder();
    	StringBuilder oldlogin=new StringBuilder();
    	
    	if(!oldLoginObj.getPassword().equals(newLoginObj.getPassword())) {
    		oldlogin.append("Password :-> "+oldLoginObj.getPassword()+"<br>");
    		newlogin.append("Password :-> "+newLoginObj.getPassword()+"<br>");
    	}
    	
       	if(!oldLoginObj.getUuid().equals(newLoginObj.getUuid())) {
    		oldlogin.append("Uuid :-> "+oldLoginObj.getUuid()+"<br>");
    		newlogin.append("Uuid :-> "+newLoginObj.getUuid()+"<br>");
    	}
       	
       	if(!oldLoginObj.getSalt().equals(newLoginObj.getSalt())) {
    		oldlogin.append("Salt :-> "+oldLoginObj.getSalt()+"<br>");
    		newlogin.append("Salt :-> "+newLoginObj.getSalt()+"<br>");
    	}
       	
       	if(!oldLoginObj.getSha1().equals(newLoginObj.getSha1())) {
    		oldlogin.append("Sha1 :-> "+oldLoginObj.getSha1()+"<br>");
    		newlogin.append("Sha1 :-> "+newLoginObj.getSha1()+"<br>");
    	}
       	
       	if(!oldLoginObj.getSha256().equals(newLoginObj.getSha256())) {
    		oldlogin.append("Sha256 :-> "+oldLoginObj.getSha256()+"<br>");
    		newlogin.append("Sha256 :-> "+newLoginObj.getSha256()+"<br>");
    	}
       	
       	if(!oldLoginObj.getMd5().equals(newLoginObj.getMd5())) {
    		oldlogin.append("Md5 :-> "+oldLoginObj.getMd5()+"<br>");
    		newlogin.append("Md5 :-> "+newLoginObj.getMd5()+"<br>");
    	}
       	
       	if(!oldLoginObj.getUsername().equals(newLoginObj.getUsername())) {
    		oldlogin.append("Username :-> "+oldLoginObj.getUsername()+"<br>");
    		newlogin.append("Username :-> "+newLoginObj.getUsername()+"<br>");
    	}
       	
        differences.put("login", "Old: " + oldlogin+ ", New: " + newlogin);
        
        return newLoginObj;
	}
	
	private Location handleLocation(Map<String, String>differences,Location oldLocationObj,Location newLocationObj) {
        //location
	    	StringBuilder newLocation=new StringBuilder();
	    	StringBuilder oldLocation=new StringBuilder();
	    	
	    	if(!oldLocationObj.getCity().equals(newLocationObj.getCity())) {
	    		oldLocation.append("City :-> "+oldLocationObj.getCity()+"<br>");
	    		newLocation.append("City :-> "+newLocationObj.getCity()+"<br>");
	    	}
	    	
	    	if(!oldLocationObj.getCountry().equals(newLocationObj.getCountry())) {
	    		oldLocation.append("Country :-> "+oldLocationObj.getCountry()+"<br>");
	    		newLocation.append("Country :-> "+newLocationObj.getCountry()+"<br>");
	    	}
	    	
	    	if(!oldLocationObj.getPostcode().equals(newLocationObj.getPostcode())) {
	    		oldLocation.append("Postcode :-> "+oldLocationObj.getPostcode()+"<br>");
	    		newLocation.append("Postcode :-> "+newLocationObj.getPostcode()+"<br>");
	    	}
	    	
	    	if(!oldLocationObj.getState().equals(newLocationObj.getState())) {
	    		oldLocation.append("State :-> "+oldLocationObj.getState()+"<br>");
	    		newLocation.append("State :-> "+newLocationObj.getState()+"<br>");
	    	}
	    	
	    	// street in location
	    	if(!oldLocationObj.getStreet().equals(newLocationObj.getStreet())) {
	    		this.handleStreet(newLocation, oldLocation, oldLocationObj.getStreet(), newLocationObj.getStreet());
	       }
	    	
	    	//coordinate
	      if(!oldLocationObj.getCoordinates().equals(newLocationObj.getCoordinates())) {
	    	 this.handleCoordinates(newLocation, oldLocation, oldLocationObj.getCoordinates(), newLocationObj.getCoordinates());
	      }
	      
	      //timezone
	      if(!oldLocationObj.getTimezone().equals(newLocationObj.getTimezone())) {
	    	 this.handleTimezone(newLocation, oldLocation, oldLocationObj.getTimezone(), newLocationObj.getTimezone());	
	      }
	      
	        differences.put("location", "Old: " + oldLocation + ", New: " + newLocation);
		
		
		return newLocationObj;
		
		
	}
	    
	    private void handleStreet(StringBuilder newLocation ,StringBuilder oldLocation ,Street oldStreet,Street newStreet) {
	    	
	    	if(!oldStreet.getName().equals(newStreet.getName())) {
    		oldLocation.append("Street-Name :-> "+oldStreet.getName()+"<br>");
    		newLocation.append("Street-Name :-> "+newStreet.getName()+"<br>");
    	    }
    	    if(oldStreet.getNumber()!=newStreet.getNumber()) {
    		oldLocation.append("Street-Number :-> "+oldStreet.getNumber()+"<br>");
    		newLocation.append("Street-Number :-> "+newStreet.getNumber()+"<br>");
    	   }
	    	
	    }
	    
	    private void handleCoordinates(StringBuilder newLocation ,StringBuilder oldLocation ,Coordinates oldCoordinates,Coordinates newCoordinates) {
	    	
	    	if(!oldCoordinates.getLatitude().equals(newCoordinates.getLatitude())) {
	    		oldLocation.append("Coordinates-Latitude :-> "+oldCoordinates.getLatitude()+"<br>");
	    		newLocation.append("Coordinates-Latitude :-> "+newCoordinates.getLatitude()+"<br>");
	    	}
	    	if(!oldCoordinates.getLongitude().equals(newCoordinates.getLongitude())) {
	    		oldLocation.append("Coordinates-Longitude  :-> "+oldCoordinates.getLongitude()+"<br>");
	    		newLocation.append("Coordinates-Longitude  :-> "+newCoordinates.getLongitude()+"<br>");
	    		
	    	}	
	    	
	    }

	    private void handleTimezone(StringBuilder newLocation ,StringBuilder oldLocation ,Timezone oldTimezone,Timezone newTimezone) {
	   
	    	  if(!oldTimezone.getDescription().equals(newTimezone.getDescription())) {
		    		oldLocation.append("Timezone-Description  :-> "+oldTimezone.getDescription()+"<br>");
		    		newLocation.append("Timezone-Description  :-> "+newTimezone.getDescription()+"<br>");
		    	}	
	    	  if(!oldTimezone.getOffset().equals(newTimezone.getOffset())) {
		    		oldLocation.append("Timezone-Offset  :-> "+oldTimezone.getOffset()+"<br>");
		    		newLocation.append("Timezone-Offset  :-> "+newTimezone.getOffset()+"<br>");
		    	}
	    }
	    
	    
	    
	//for html output
	public String generateHtmlFromDifferences(Map<String, String> differences) {
	    StringBuilder htmlBuilder = new StringBuilder();

	    // Start HTML content
	    htmlBuilder.append("<html><body>");
	    htmlBuilder.append("<h3>User Differences</h3>");
	    htmlBuilder.append("<table border='1' style='border-collapse:collapse;'>");
	    htmlBuilder.append("<tr><th>Field</th><th>Old Value</th><th>New Value</th></tr>");

	 // Add rows for each difference
	    for (Map.Entry<String, String> entry : differences.entrySet()) {
	        String[] values = entry.getValue().split(", New: ");
	        
	        // Validate that the split resulted in exactly two parts
	        if (values.length == 2) {
	            String oldValue = values[0].replace("Old: ", "").trim();
	            String newValue = values[1].trim();

	            htmlBuilder.append("<tr>");
	            htmlBuilder.append("<td>").append(entry.getKey()).append("</td>");
	            htmlBuilder.append("<td>").append(oldValue).append("</td>");
	            htmlBuilder.append("<td>").append(newValue).append("</td>");
	            htmlBuilder.append("</tr>");
	        } else {
	            // Handle cases where the value does not match the expected pattern
	            htmlBuilder.append("<tr>");
	            htmlBuilder.append("<td>").append(entry.getKey()).append("</td>");
	            htmlBuilder.append("<td colspan='2'>Invalid format: ").append(entry.getValue()).append("</td>");
	            htmlBuilder.append("</tr>");
	        }
	    }
	    // End HTML content
	    htmlBuilder.append("</table>");
	    htmlBuilder.append("</body></html>");

	    return htmlBuilder.toString();
	}

}

