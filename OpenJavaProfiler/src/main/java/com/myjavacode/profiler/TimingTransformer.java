package com.myjavacode.profiler;

import javassist.CannotCompileException;
import javassist.ClassMap;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import javassist.bytecode.AnnotationsAttribute;

public class TimingTransformer {
    public static void addTiming(CtClass clas) throws NotFoundException, CannotCompileException, ClassNotFoundException {
        CtMethod[] declaredMethods;
        StringBuilder socketMethodBody = new StringBuilder("private void logToSocket(String methodName, long executionTime){\ttry\t{\tjava.net.Socket clientSocket = new java.net.Socket(\"localhost\", 6789);\t\tjava.io.DataOutputStream outToServer = new java.io.DataOutputStream(\t\tclientSocket.getOutputStream());\t\toutToServer.writeBytes(this.getClass().getName()+\".\"+methodName +\" \"+ executionTime +\" ms. \");\t\tclientSocket.close();\t}\tcatch(Exception e)\t{\t } }");
        CtMethod newmethod = CtNewMethod.make((String)socketMethodBody.toString(), (CtClass)clas);
        clas.addMethod(newmethod);
        String mname = null;
        String newName = null;
        String type = null;
        StringBuilder body = null;
        CtMethod newMethod = null;
        CtMethod[] arrctMethod = declaredMethods = clas.getDeclaredMethods();
        int n = arrctMethod.length;
        int n2 = 0;
        while (n2 < n) {
            CtMethod ctMethod = arrctMethod[n2];
            if ((ctMethod.getModifiers() & 8) != 8 && (ctMethod.getModifiers() & 2) != 2) {
                mname = ctMethod.getName();
                
                //Object[] annotations = ctMethod.getAnnotations();
                
                //java.lang.annotation.Annotation[] annotations = (java.lang.annotation.Annotation[])ctMethod.getAnnotations();
                
                //AnnotationsAttribute attr = new AnnotationsAttribute(clas, AnnotationsAttribute.visibleTag);

                AnnotationsAttribute attr;
                
                //attr.getAnnotations();
                //attr.setAnnotation(annotation);
                
                CtField cfield;
                //cfield.getFieldInfo().
                // to Remove method - http://stackoverflow.com/questions/30283508/how-to-remove-a-method-using-javassist
                /*ClassPool pool = ClassPool.getDefault();  
                CtClass ctClass = pool.get("javassist.RemoveMethod");  
                CtMethod ctm = ctClass.getDeclaredMethod("DoubleCheck");  
                ctClass.removeMethod(ctm);
				*/
                
                
                
                newName = String.valueOf(ctMethod.getName()) + "$impl";
                ctMethod.setName(newName);
                newMethod = CtNewMethod.copy((CtMethod)ctMethod, (String)mname, (CtClass)clas, (ClassMap)null);
                type = ctMethod.getReturnType().getName();
                body = new StringBuilder();
                body.append("{\nlong start = System.currentTimeMillis();\n");
                if (!type.equals("void")) {
                    body.append(String.valueOf(type) + " result = ");
                }
                body.append(String.valueOf(newName) + "($$);\n");
                body.append("logToSocket(\"" + mname + "\"" + "," + "(System.currentTimeMillis()-start));");
                if (!type.equals("void")) {
                    body.append("return result;\n");
                }
                body.append("}");
                newMethod.setBody(body.toString());
                clas.addMethod(newMethod);
            }
            ++n2;
        }
    }
}