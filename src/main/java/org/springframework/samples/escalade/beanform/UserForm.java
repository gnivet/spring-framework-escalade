package org.springframework.samples.escalade.beanform;

public class UserForm {
 
    private Long userId;
    private String userName; 
    public UserForm() {
 
    }
 
   
 /**
	 * @param userName
	 * @param password
	 */
	public UserForm(String userName, String password) {
		super();
		this.userName = userName;
	}



    public Long getUserId() {
        return userId;
    }
 
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    

	public void setPassword(String password) {
	}


	public CharSequence getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
 
   
   
 
   
}

