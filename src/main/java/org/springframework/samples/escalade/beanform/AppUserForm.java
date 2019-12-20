package org.springframework.samples.escalade.beanform;

public class AppUserForm {
 
  //  private Long userId;
    private String userName;   
    private String password;
    
    public AppUserForm() {
 
    }
 
    //public AppUserForm(Long userId, String userName, //
    		public AppUserForm( String userName, //
            String password) {
     //   this.userId = userId;
        this.userName = userName;
        this.password = password;       
    }
 /*
    public Long getUserId() {
        return userId;
    }
 
    public void setUserId(Long userId) {
        this.userId = userId;
    }
*/
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
   
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
   
}

