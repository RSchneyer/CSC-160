import java.lang.reflect.*;

public class ReflectionsInMyMind {
    private Class classType;
    private Method[] methods;
    private Constructor[] constructors;
    private Field[] fields;
    private Object theObject;

    public ReflectionsInMyMind(Object o) {
        theObject = o;
        classType = o.getClass();
        methods = classType.getMethods();
        constructors = classType.getConstructors();
        fields = classType.getFields();
    }
    
    public static void main (String [] args) {
        ReflectionsInMyMind mirror = new ReflectionsInMyMind(new String());
        System.out.println(mirror.constructorParade());
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
    
    public String constructorParade() {
        String parade = "";
        for (int x=0; x<constructors.length; x++) {
            parade = parade + getConstructorFormatted(constructors[x]) + "\n";
        }
        return parade;
    }
}