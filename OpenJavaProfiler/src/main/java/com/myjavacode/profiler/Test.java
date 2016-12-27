package com.myjavacode.profiler;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub

		/*
		   String classPath = System.getenv("JBOSS_HOME");
           
           classPath = classPath+"standalone/tmp/vfs/temp/";
           
           File file = new File(classPath);
           
           if(file.listFiles().length > 0)
           {
           	File subDir1 = file.listFiles()[0];
           	
           	//classPath = classPath + subDir1.getName()+"/";
           	
           	File[] warFiles = subDir1.listFiles();
           	
           	String profilingComponent = "esoko-web.war";//prop.getProperty("profilingComponent");
           	
           	for(File warFile : warFiles)
           	{
           		if(warFile.getName().startsWith(profilingComponent))
           		{
           			classPath = warFile.getCanonicalPath()+"/WEB-INF/classes";
           			
           			System.out.println("Final "+warFile.getCanonicalPath());
           		}
           	}
           	
           	
           	
           	
           }
           
           60
           new Thread((Runnable)new TCPServer()).start();
           */
		SimpleDateFormat displayFormat = new SimpleDateFormat("HH");
	    SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
	    Date date = parseFormat.parse("10:30 PM");
	    //System.out.println(displayFormat.format(date));
		
	    BigDecimal actualTime = new BigDecimal(50);
	    
        BigDecimal timeinMinutes = actualTime.divide(new BigDecimal(60), RoundingMode.FLOOR);
        //BigDecimal seconds = actualTime.subtract(timeinMinutes.multiply(new BigDecimal(60)));
        //seconds = seconds.setScale(2);
        long seconds = (actualTime.longValue() - (timeinMinutes.longValue()*60));
        String formatted = String.format("%02d", seconds);

        BigDecimal duration = new BigDecimal(timeinMinutes+"."+formatted);
        
       // double secondsValue = timeinMinutes.doubleValue() - Math.floor(timeinMinutes.doubleValue());
        System.out.println(timeinMinutes);
        System.out.println(formatted);
        System.out.println(duration);


        
        System.out.println(new BigDecimal("2.5").setScale(0,RoundingMode.HALF_UP));
        
        

	    
	}

}
