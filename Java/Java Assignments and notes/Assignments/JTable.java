void table(int max)
	{
		
		table1.setRowHeight(30);
		JScrollPane tablepane = new JScrollPane(table1);	        
		tablepane.setLocation(50,600);
		tablepane.setSize(sw-100,300);
		        
		 // Set up the JDBC connection
		try 
		{
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/internalmarks","root","");
		    String q1="SELECT stuid,stuname FROM students where studept=? && studegree=?";
		    PreparedStatement ps1=connection.prepareStatement(q1);
		    ps1.setString(1,deptCB.getSelectedItem().toString());
		    ps1.setString(2,degCB.getSelectedItem().toString());
		    ResultSet resultSet = ps1.executeQuery();
		    ResultSetMetaData metaData = resultSet.getMetaData();
		    int columnCount = metaData.getColumnCount();
		    
		    String[] column=new String[3];
		    column[0]="Attendance";
		    column[1]="Maximum Marks";
		    column[2]="Obtained Marks";
		    
		    
		    //Adding the Column name from DB into the Table..!
		    for (int i = 1; i <= columnCount; i++) 
		    {
		        model1.addColumn(metaData.getColumnName(i));
		    }
		    table1.setAutoResizeMode(table1.AUTO_RESIZE_ALL_COLUMNS);
		    
		    //Adding Extra Columns into the Table..!
		    model1.addColumn(column[0]);
		    model1.addColumn(column[1]);
		    model1.addColumn(column[2]);
		    
		    
		    //Add Row into the Table..!
		    while (resultSet.next()) 
		    {
		    	Object[] row = new Object[columnCount+3];
		       	for (int i = 0; i < columnCount; i++) 
		       	{
		       	    row[i] = resultSet.getString(i+1);
		       	    row[3]=max;
		       	}
		        
		       	model1.addRow(row);
		    }
		     // Close the connections
		    resultSet.close();
		    ps1.close();
		    connection.close();
		 } catch (Exception e) {
		     e.printStackTrace();
		 }

		
		mainpanel.add(tablepane);
	}