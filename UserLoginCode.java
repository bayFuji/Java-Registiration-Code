import java.util.Scanner;
public class UserLoginCode {

	public static void main(String[] args) {
		
		int statue=0;
		
		String username=null, password=null, enteredUsername=null, enteredPassword=null, name = "", pass = "";
		String passwords[] = new String[30];
		String usernames[] = new String[30];
		
		int num1=3, num2=0, num3=0, passwordNum=0, totalUser=0, coo=0;
		
		char karakter;
		
		boolean passwordControl=false, controlExit1=true, control1=false, user=true, n=true, k=true, l=true, m=true;
		
		do {
			controlExit1=true;
			System.out.println("Press '1' for login, '2' for register: ('exit' for main menu.)");
			Scanner input = new Scanner(System.in);
			int choice1 = input.nextInt();
			
			switch(choice1) {
			case 1:
				
					controlExit1=true;
					do {
						num2=0;
						System.out.println("Enter your 'Username': ");
						enteredUsername = input.next();
							
						if (!enteredUsername.equals("exit")) {
							for(int i=0; i<=totalUser;i++)
								if(enteredUsername.equals(usernames[i])) {
									num2++;
									name = usernames[i];
									passwordNum=i;}
	
							if (num2==0 && !enteredUsername.equals("exit")) {
								System.out.println("Username can not found!");
								continue;}
						}	
					
					} while(num2==0 && !enteredUsername.equals("exit"));
					
					if (!enteredUsername.equals("exit")) {
						num1=3;
						do {	
							num3=0;
							System.out.println("Please enter your 'Password' "+name+".");
							enteredPassword = input.next();
							
							if (!enteredPassword.equals("exit")) {
								
								if(enteredPassword.equals(passwords[passwordNum])) {
									num3++;
									pass=passwords[passwordNum];
									System.out.println("Welcome "+name+".");}
								
								else if (num3==0 && num1>0 && !enteredPassword.equals("exit")) {
									System.out.println("Password is not correct! You have "+num1+" attempts left");
									num1--;
									continue;}
								
								else if (num1==0 && !enteredPassword.equals("exit")) {
									System.out.println("!! You have exceeded the maximum attempts limit, you will be kicked out of the system. !!");
									System.exit(0);}
							
							}	
						
						} while (num3==0 && !enteredPassword.equals("exit"));
					
						
					
					}
	
			break;
			
			case 2:
					
				do {
					user = true;
					System.out.println("Create an 'Username': ");
					username = input.next();
					
					for(int i=0; i<=totalUser;i++)
						if(username.equals(usernames[i])) {
							user = false;
							System.out.println("This username has been taken before !");
							break;}
				
				}while(!user);
					
					if (!username.equals("exit")) {
					
						do {
							k = l = m = n = true;
							System.out.println("Please create a 'Password' "+username+".");
							password = input.next();
							
							if (password.equals("exit")==false) {
								
								char[] chars = password.toCharArray();									coo=0;
									
									for (char c : chars) {
										  if (c >= 48 && c <= 57) {
											  k=false;}
										  else if (c>=65 && c<=90) {
											  l=false;}
										  else if (c>=33 && c<=47) {
											  m=false;}
										  else if (c>=97 && c<=122) {
											  n=false;}											}
							
								if(k || l || m || n )
									System.out.println("Your password should contain at least an upper case character and at least one number!");
							}
									
						}while ((k || l || m || n )&& !password.equals("exit"));
								
							if (!password.equals("exit")) {
								System.out.println("You succesfully created your account "+username+".");
								
								usernames[totalUser] = username;
								passwords[totalUser] = password;
								totalUser++;
						
							}
								
						} 
				
			break;
		
			}
	
		}while (!control1);
		
	}

}
