import java.lang.reflect.*;

public class Reflections2 {
    private Class classType;
    private Method[] methods;
    private Constructor[] constructors;
    private Field[] fields;
    private Object theObject;

    public Reflections2(Object o) {
        theObject = o;
        classType = o.getClass();
        methods = classType.getMethods();
        constructors = classType.getConstructors();
        fields = classType.getFields();
    }
    
    public static void main (String [] args) {
        Reflections2 mirror = new Reflections2(new Integer(5));
        System.out.println(mirror.constructorParade());
        System.out.println(mirror.methodParade());
    }
    
    public String getMethodFormatted(Method m){
        String gmf = "";
        gmf += m.getName();
        gmf += "(";
        Class[] params = m.getParameterTypes();
        for(int i=0;i<params.length;i++){
            gmf += params[i].getName();
            if(i<params.length - 1){
                gmf += ", ";
            }
        }
        gmf += ")";
        return gmf;
    }

    public String getConstructorFormatted(Constructor c) {
        String gcf = "";
        gcf = gcf + c.getName();
        gcf = gcf + "(";
        Class[]params = c.getParameterTypes();
        for (int x=0; x<params.length; x++) {
            gcf = gcf + params[x].getName();
            if (x < params.length - 1)
                gcf = gcf + ", ";
        }
        gcf=gcf + ")";
        return gcf;
    }
    public String methodParade(){
        String parade = "";
        for(int x=0;x<methods.length;x++){
            parade += (getMethodFormatted(methods[x]) +"\n");
        }
        return parade;
    }
    public String constructorParade() {
        String parade = "";
        for (int x=0; x<constructors.length; x++) {
            parade = parade + getConstructorFormatted(constructors[x]) + "\n";
        }
        return parade;
    }
}