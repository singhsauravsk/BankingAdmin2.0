<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.zycus.db.dao.AccountDao"  %>
<%@ page import = "com.zycus.pojo.accounts.Account"  %>
<%@ page import = "java.util.List"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Admin</title>
	</head>
	<body>
		<h1>Welcome          
			<%= request.getAttribute("username") %>
		</h1>
		</br>
		<form action = "new-account.do" method = "post">
			Account Holder Name : <input type = "text" name = "holderName"> 
			Account Type : 
			<select id="accountType" name = "accountType">
                <option value="Saving">Saving</option>
                <option value="Current">Current</option>
                <option value="Select" selected>Select</option>
            </select> 
            <input type = "submit" value = "Create New Account">
		</form>
		
		<table> 
			<tr>
				<td>Account Number</td>
				<td>AccountHolder</td>
				<td>AccountType</td>
			</tr>

			<%
				List <Account> allAccounts = AccountDao.getAllAccount();
			%>
			<%= allAccounts.size() %>
			<% 
				/*for(Account account : allAccounts) {
				    
					out.print("<tr><td>"+account.getAccountNumber()+"</td><td>"+account.getHolderName()+"</td><td>"
							+account.getAccountType()+"</td></tr>");
				 }*/
			%>
		</table>
	</body>
</html>