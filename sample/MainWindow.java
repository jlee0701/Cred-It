

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.sql.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;

public class MainWindow implements Initializable {

    private Main main;

    public void setMain(Main main){
        this.main=main;
    }
    
    @Override
	public void initialize(URL url, ResourceBundle resourceBundle)
	{
	    whichCard.setToggleGroup(group);
	    addCard.setToggleGroup(group);
	    ownedCards.setToggleGroup(group);
	    
	}
    
    @FXML
    private CheckBox MemberSSNCheckBox;

    @FXML
    private TextField MemberSSNTextField;
    
    @FXML
    ToggleGroup group = new ToggleGroup();
    
    @FXML
    private Label RewardCategoryLabel;
    
    @FXML
    private ComboBox RewardCategoryCBOX;
    
    @FXML
    private Label RewardTypeLabel;
    
    @FXML
    private ComboBox RewardTypeCBOX;
    
    @FXML
    private Label test5;
    
    @FXML
    private TextField test6;
    
    @FXML
    private Label test7;
    
    @FXML
    private TextField test8;
    
    @FXML
	private CheckBox MemberEmailCheckBox;

	@FXML
	private TextField MemberEmailTextField;
	
	@FXML
	private CheckBox MemberAnnualIncomeCheckBox;

	@FXML
	private TextField MemberAnnualIncomeTextField;
    

    @FXML
    private RadioButton deleteCard;
    
    @FXML
    private Label deleteCardNumber;

    @FXML
    private TextField deleteCardNumberTF;


    @FXML
    private Label AddCardNumber;

    @FXML
    private TextField AddCardNumberTF;

    @FXML
    private Label AddCurrentBal;

    @FXML
    private TextField CurrentBalTF;

    @FXML
    private Label MaxBalance;

    @FXML
    private TextField MaxBalanceTF;


    @FXML
    private Label AddCCV;

    @FXML
    private TextField CCVTF;

    @FXML
    private Label Expiration;

    @FXML
    private TextField ExpirationTF;

    @FXML
    private CheckBox OwnCNumCB;

    @FXML
    private TextField OwnCNumTF;

    @FXML
    private CheckBox OwnCCVCB;

    @FXML
    private TextField OwnCCVTF;

    @FXML
    private CheckBox OwnCurBalCB;

    @FXML
    private TextField OwnCurBalTF;

    @FXML
    private CheckBox OwnMaxBalCB;

    @FXML
    private TextField OwnMaxBalTF;

    @FXML
    private CheckBox OwnExpCB;

    @FXML
    private TextField OwnExpTF;

    @FXML
    private CheckBox OwnAvaiBalCB;

    @FXML
    private TextField OwnAvaiBalTF;

    @FXML
    private CheckBox OwnCardIDCB;

    @FXML
    private TextField OwnCardIDTF;

    @FXML
    private CheckBox OwnSSNCB;

    @FXML
    private TextField OwnSSNTF;

    @FXML
    private CheckBox CRewIDCB;

    @FXML
    private TextField CRewIDTF;

    @FXML
    private CheckBox CRewDescCB;

    @FXML
    private TextField CRewDescTF;

    @FXML
    private CheckBox CRewCatCB;

    @FXML
    private TextField CRewCatTF;

    @FXML
    private CheckBox CRewPPDCB;

    @FXML
    private TextField CRewPPDTF;

    @FXML
    private CheckBox CRewMPDCB;

    @FXML
    private TextField CRewMPDTF;

    @FXML
    private CheckBox CRewOffCatCB;

    @FXML
    private TextField CRewOffCatTF;

    @FXML
    private CheckBox CRewOffMercCB;

    @FXML
    private TextField CRewOffMercTF;

    @FXML
    private CheckBox CRewOffTypeCB;

    @FXML
    private TextField CRewOffTypeTF;

    @FXML
    private CheckBox CRewOffAmt1CB;

    @FXML
    private CheckBox CRewOffAmt2CB;

    @FXML
    private CheckBox CRewOffAmt3CB;

    @FXML
    private CheckBox CRewOffAmt4CB;

    @FXML
    private CheckBox CRewCashBackCB;

    @FXML
    private TextField CRewCashBackTF;

    @FXML
    private TextArea ResultsTextArea;

    @FXML
    private Button SearchButton;

    @FXML
    private Button InsertButton;

    @FXML
    private Button UpdateButton;

    @FXML
    private Button DeleteButton;
    
    @FXML
    private RadioButton whichCard;
   
    @FXML
    private RadioButton ownedCards;
	
    @FXML
	private void search(ActionEvent event)
	{	
    	System.out.println("Clicked!");
		
		TimeZone tz = TimeZone.getDefault();
		//String url = "jdbc:mysql://localhost:3306/Project4"; //Connector that works for team
		String url = "jdbc:mysql://localhost:3306/DELIVERABLE4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=" + tz.getID();
		//specify username and password
		String username = "root";
		String password = "1234";
		
    	if(MemberSSNCheckBox.isSelected() && group.getSelectedToggle().equals(whichCard) ){
    		try {
    			int ssn = Integer.parseInt(MemberSSNTextField.getText());
    		
	        	String rc = String.valueOf(RewardCategoryCBOX.getValue());
	        	String rt = String.valueOf(RewardTypeCBOX.getValue());
	    		System.out.println(ssn);
	    		System.out.println(rc);
	    		System.out.println(rt);
	    		String ssnParse = String.valueOf(ssn);
	    		
    		
	    		if(ssnParse.length() != 9) {
	    			ResultsTextArea.setText("Please enter a valid number!");
	    		}else {
	    		
		    		try {
		    			Connection connection = DriverManager.getConnection(url, username, password);
		    			System.out.println("Database connected!");
		    			Statement stmt;
		    			String query;
		    			ResultSet rs;
		    			
						stmt = connection.createStatement();
						query = "SELECT * FROM DELIVERABLE4.OWN INNER JOIN DELIVERABLE4.MEMBER USING(SSN) INNER JOIN CREDITCARD USING(CardID) INNER JOIN HASREWARD USING(CardID) INNER JOIN CARDREWARD USING(RewardID) WHERE SSN = '" + ssn + "' AND RewardCategory = '" + rc + "';";
						
						rs = stmt.executeQuery(query);
						String result = "";
						
						ResultsTextArea.setText("\nSSN : " + ssn);
						
						while(rs.next()) {
							String CardName = rs.getString("CardName");
							String CardType = rs.getString("CardType");
							String RewardCategory = rs.getString("RewardCategory");
							String RewardAmountPointsPerDollar = rs.getString("RewardAmountPointsPerDollar");
							String RewardAmountCashBack = rs.getString("RewardAmountCashBack");
							String RewardAmountMilesPerDollar = rs.getString("RewardAmountMilesPerDollar");
							result = "\n\tCard Name : " + CardName + "\n\t\tCard Type : " + CardType +
									"\n\t\tReward Category : " + RewardCategory + "\n\t\tReward Points Per Dollar Spend : " + RewardAmountPointsPerDollar + 
									"\n\t\tReward Cash Back Per Dollar Spend : " + RewardAmountCashBack +
									"\n\t\tReward Miles Per Dollar Spend : " + RewardAmountMilesPerDollar;
							System.out.print(result);
							ResultsTextArea.appendText(result);
						}
		        			
		    			
		    		} catch (SQLException e) {
		    		    throw new IllegalStateException("Cannot connect the database!", e);
		    		}
	    		}
    		}catch(NumberFormatException e){
    			ResultsTextArea.setText("Please enter a valid number!");
    		}
	    		
    	}else if (MemberSSNCheckBox.isSelected() && group.getSelectedToggle().equals(ownedCards)){ //if (MemberSSNCheckBox.isSelected()){
    		try {
	    		int ssn = Integer.parseInt(MemberSSNTextField.getText());
	    		String ssnParse = String.valueOf(ssn);
	    		System.out.println(ssn);
	    		
	    		if(ssnParse.length() != 9) {
	    			ResultsTextArea.setText("Please enter a valid SSN!");
	    		}else {
	    		
		    		try {
		    			Connection connection = DriverManager.getConnection(url, username, password);
		    			System.out.println("Is Checked"); 
		    			Statement stmt;
		    			String query;
		    			ResultSet rs;
		    			
		    			stmt = connection.createStatement();
		    			
		    			query =  "SELECT * FROM DELIVERABLE4.MEMBER INNER JOIN OWN USING(SSN) INNER JOIN CREDITCARD USING(CardID) WHERE SSN = " + ssn;
		    			rs = stmt.executeQuery(query);
						String result = "";
						
						
						ResultsTextArea.setText("\nCards Owned By [" + ssn + "] :");
		    			while(rs.next()) {
		    				String firstName = rs.getString("FirstName");
		    				String lastName = rs.getString("LastName");
		    				String cardName = rs.getString("CardName");
		    				String cardNum = rs.getString("CardNumber");
		    				result = "\n\tCard Name : " + cardName + "\n\t\tCard Number : " + cardNum + "\n\t\tFirst Name : "+ firstName + "\n\t\tLast Name : "+ lastName;
		    				System.out.print(result);
		    				ResultsTextArea.appendText(result);
		    			}
		    			
		    			
		    		} catch(Exception nfe) {
		    			nfe.printStackTrace();
		    		}
	    		}
    		}catch(NumberFormatException e){
    			ResultsTextArea.setText("Please enter a valid number!");
    		}
    	}
	
    	/*
    	else {
    		System.out.println("No Is Checked");
    	}
    	*/
	}
    
    @FXML
	private void delete(ActionEvent event)

    {
		  System.out.println("Delete Selected");
	  	  
	  	  if(deleteCard.isSelected()) {
	  		 int ssn = Integer.parseInt(MemberSSNTextField.getText());
	  		 String cardNumber = String.valueOf(deleteCardNumberTF.getText());
	  		 System.out.println(ssn);
	  		 System.out.println(cardNumber);
	  		
	        if(MemberSSNCheckBox.isSelected())
	        {
	            System.out.println("Is Checked");
	           // System.out.println("Enter SSN to Delete");
	            try {

	                TimeZone tz = TimeZone.getDefault();
	        		//String url = "jdbc:mysql://localhost:3306/Project4"; //Connector that works for team
	        		String url = "jdbc:mysql://localhost:3306/DELIVERABLE4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=" + tz.getID();
	        		//specify username and password
	        		String username = "root";
	        		String password = "1234";
	                String sql = "DELETE FROM DELIVERABLE4.OWN WHERE CardNumber = '" + cardNumber + "' AND SSN = '" + ssn + "';";
	                
	                Connection connection = DriverManager.getConnection(url, username, password);
	                Statement stmt = connection.createStatement();
	                stmt.executeUpdate(sql);
	                
	                //String issuerName = rs.getString("IssuerName");
	                
	                //while(rs.next()) {
	                String result = "\nCard [" + cardNumber + "] of Member [" + ssn + "] is permanently deleted from the records!"; 
	                    		//+ "\nIssuerName" + issuerName;
	                //}
	                ResultsTextArea.setText(result);
	            } catch(Exception nfe) {
	                nfe.printStackTrace();
	            }
	       
	        }else {
	            System.out.println("Not Checked");
	        }
	  	  }
    }
    
    
    
    @FXML
	private void update(ActionEvent event)

	{
		 System.out.println("Selected");
	        if(MemberAnnualIncomeCheckBox.isSelected() && MemberSSNCheckBox.isSelected())
	        {
	            System.out.println("Is Checked");
	           // System.out.println("Enter SSN to Delete");
	            try {
	                int ssn = Integer.parseInt(MemberSSNTextField.getText());
	                int income = Integer.parseInt(MemberAnnualIncomeTextField.getText());
	               

	                TimeZone tz = TimeZone.getDefault();
	        		//String url = "jdbc:mysql://localhost:3306/Project4"; //Connector that works for team
	        		String url = "jdbc:mysql://localhost:3306/DELIVERABLE4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=" + tz.getID();
	        		//specify username and password
	        		String username = "root";
	        		String password = "1234";
	        		ResultSet rs = null;
	                String result = "";
	                int oldIncome = 0;
	                String old = "SELECT * FROM DELIVERABLE4.MEMBER WHERE SSN = " + ssn + ";";
	                Connection connection = DriverManager.getConnection(url, username, password);
	                Statement stmt = connection.createStatement();
	                rs = stmt.executeQuery(old);
	                
	    			while(rs.next()) {
	    				oldIncome = rs.getInt("AnnualIncome");
	    				System.out.print(result);
	    			}
	        		
	        		String sql = "UPDATE DELIVERABLE4.MEMBER SET AnnualIncome = '" + income + "' WHERE SSN = " + ssn + ";";
	                rs = null;
	                connection = DriverManager.getConnection(url, username, password);
	                stmt = connection.createStatement();
	                stmt.executeUpdate(sql);
	                result = "";
	                
	                //String issuerName = rs.getString("IssuerName");
	                
	               // while(rs.next()) {
	                    //String issuerName = rs.getString("AmericanExpress");
	                result += "\nSSN : " + ssn + "\nUpdated Annual Income : " + income + "\tFrom  " + oldIncome;
	                    		//+ "\nIssuerName" + issuerName; 
	                    		//+ "\nIssuerName" + issuerName;
	                    //System.out.println(phone + "Record Deleted");
	               // }
	                ResultsTextArea.setText(result);
	            } catch(Exception nfe) {
	                nfe.printStackTrace();
	            }
	        }
	        else if(MemberEmailCheckBox.isSelected() && MemberSSNCheckBox.isSelected()) {
	        	  try {
	        		  
	        		  int ssn = Integer.parseInt(MemberSSNTextField.getText());
		              String email = MemberEmailTextField.getText();
		              System.out.println("email");
		              System.out.println(ssn);

		              	TimeZone tz = TimeZone.getDefault();
		      			//String url = "jdbc:mysql://localhost:3306/Project4"; //Connector that works for team
		      			String url = "jdbc:mysql://localhost:3306/DELIVERABLE4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=" + tz.getID();
		                String username = "root";
		                String password = "1234";
		                ResultSet rs = null;
		                String result = "";
		                String oldEmail = null;
		                String old = "SELECT * FROM DELIVERABLE4.MEMBER WHERE SSN = " + ssn + ";";
		                Connection connection = DriverManager.getConnection(url, username, password);
		                Statement stmt = connection.createStatement();
		                rs = stmt.executeQuery(old);
		                
		    			while(rs.next()) {
		    				oldEmail = rs.getString("Email");
		    				System.out.print(result);
		    			}
		                
		                String sql = "UPDATE DELIVERABLE4.MEMBER SET Email = '" + email + "' WHERE SSN = " + ssn + ";";
		                connection = DriverManager.getConnection(url, username, password);
		                stmt = connection.createStatement();
		                stmt.executeUpdate(sql);
		                
		                result += "\nSSN : " + ssn + "\nUpdated Email : " + email + "\tFrom " + oldEmail;
		                ResultsTextArea.appendText(result);
		            } catch(Exception nfe) {
		                nfe.printStackTrace();
		            }
		        }
	        

	        else {
	            System.out.println("Not Checked");
	        }

         }
    
    @FXML
    private RadioButton addCard;
    
    @FXML
    private Label NewCardSelect;
    
    @FXML
    private ComboBox cardSelection;
    
    @FXML 
    private void insert(ActionEvent event) { //insert a new member
  	  
  	  System.out.println("Clicked insert button");
  	  
  	  if(addCard.isSelected()) {
  		 int ssn = Integer.parseInt(MemberSSNTextField.getText());
  		  String cardName = String.valueOf(cardSelection.getValue());
  		  String cardNumber = String.valueOf(AddCardNumberTF.getText());
  		  int currentBal = Integer.parseInt(CurrentBalTF.getText());
  		  int maxBal = Integer.parseInt(MaxBalanceTF.getText());
  		  int ccv = Integer.parseInt(CCVTF.getText());
  		  int exp = Integer.parseInt(ExpirationTF.getText());
  		 System.out.println(cardName);
  		  String cardID = null;
  		  
  		  
  		  if(cardName.equals("Chase Freedom Unlimited")) { 
  			  cardID = "c1";
  		  }else if(cardName.equals("American Express Gold")) { 
  			  cardID = "c10";
  		  }else if(cardName.equals("American Express Green")) { 
  			  cardID = "c11";
  		  }else if(cardName.equals("Wells Fargo Platinum")) { 
  			  cardID = "c12";
  		  }else if(cardName.equals("Wells Fargo Cash Wise")) { 
  			  cardID = "c13";
  		  }else if(cardName.equals("Wells Fargo Rewards")) { 
  			  cardID = "c14";
  		  }else if(cardName.equals("Chase Sapphire Preferred")) { 
  			  cardID = "c2";
  		  }else if(cardName.equals("Chase Sapphire Reserve")) { 
  			  cardID = "c3";
  		  }else if(cardName.equals("Cash Rewards")) { 
  			  cardID = "c5";
  		  }else if(cardName.equals("Sonesta")) { 
  			  cardID = "c6";
  		  }else if(cardName.equals("Barclaycard Financing Visa")) { 
  			  cardID = "c7";
  		  }else if(cardName.equals("RCI")) { 
  			  cardID = "c8";
  		  }else {
  			  System.out.println("card name error");
  		  }
  		System.out.println(cardID);
  		  
  		try {
            System.out.println("email");
            System.out.println(ssn);
            

            	TimeZone tz = TimeZone.getDefault();
    			//String url = "jdbc:mysql://localhost:3306/Project4"; //Connector that works for team
    			String url = "jdbc:mysql://localhost:3306/DELIVERABLE4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=" + tz.getID();
              String username = "root";
              String password = "1234";
              ResultSet rs = null;
              String result = "";
              String sql = "INSERT INTO `OWN` (`CardID`, `SSN`, `CardNumber`, `MaxBalance`, `CurrentBalance`, `CCV`, `Expiration`) VALUES " + 
              			   "('" + cardID + "', '" + ssn + "', '" + cardNumber + "', '" + maxBal + "', '" + currentBal + "', '" + ccv + "', '" + exp + "');" ;
              Connection connection = DriverManager.getConnection(url, username, password);
              Statement stmt = connection.createStatement();
              stmt.executeUpdate(sql);
              
                  result += "\nCard [" + cardName + "] is added to member ssn [" + ssn + "]!";
              ResultsTextArea.appendText(result);
          } catch(Exception nfe) {
              nfe.printStackTrace();
          }
  		  
  	  }
  	}
}
