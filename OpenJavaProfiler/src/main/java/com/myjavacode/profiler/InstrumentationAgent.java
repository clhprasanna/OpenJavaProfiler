package com.myjavacode.profiler;

import com.myjavacode.profiler.TCPServer;
import com.myjavacode.profiler.TimingTransformer;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.Properties;
import javassist.ClassPath;
import javassist.ClassPool;
import javassist.CtClass;

public class InstrumentationAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
    	
    	InstrumentationThread iThread = new InstrumentationThread();
    	iThread.start();
    	
    	
    	/*
        System.out.println("Entering Premain method");
        ArrayList list = new ArrayList();
        try {
            String configLocation = System.getenv("OPENPROFILER_HOME");
            Properties prop = new Properties();
            FileInputStream stream = new FileInputStream(String.valueOf(configLocation) + "/conf/openprofiler.properties");
            prop.load(stream);
            String classPath = prop.getProperty("appClassPath");
            
           // /mnt/01D6BA885EADB284/Servers/JBOSS-EAP-6.4/

            // For Jboss
            classPath = System.getenv("JBOSS_HOME");
            
            classPath = classPath+"standalone/tmp/vfs/temp/";
            
            File tempDir = new File(classPath);

            
            // sleep for 1 minute & do the remaining steps in a seperate Thread
            Thread.sleep(1000*60);
            
            
            if(tempDir.listFiles().length > 0)
            {
            	File subDir1 = tempDir.listFiles()[0];
            	
            	File[] warFiles = subDir1.listFiles();
            	
            	String profilingComponent = prop.getProperty("profilingComponent");
            	
            	for(File warFile : warFiles)
            	{
            		if(warFile.getName().startsWith(profilingComponent))
            		{
            			classPath = warFile.getCanonicalPath()+"/WEB-INF/classes";
            		}
            	}
            	
            }
            
            
            String profilingPackage = prop.getProperty("profilingPackage");
            File dir = new File(String.valueOf(classPath) + "/" + profilingPackage);
            File[] files = dir.listFiles();
            if (files != null) {
                File[] arrfile = files;
                int n = arrfile.length;
                int n2 = 0;
                while (n2 < n) {
                    File file = arrfile[n2];
                    ClassPool.getDefault().appendClassPath(classPath);
                    String fqClass = String.valueOf(profilingPackage.replace("/", ".")) + "." + file.getName().substring(0, file.getName().indexOf("."));
                    CtClass clas = ClassPool.getDefault().get(fqClass);
                    if (clas == null) {
                        System.err.println("Class " + fqClass + " not found");
                    } else if (!clas.isInterface()) {
                        TimingTransformer.addTiming((CtClass)clas);
                        clas.writeFile(classPath);
                    }
                    ++n2;
                }
            }
            new Thread((Runnable)new TCPServer()).start();
            System.out.println("Exiting Premain method");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    */}
}