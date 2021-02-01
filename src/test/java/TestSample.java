import java.io.IOException;
import java.util.ArrayList;

public class TestSample {
public static void main(String[] args) throws IOException {
dataDriven d=new dataDriven();
ArrayList data=d.getData("Add Profile");

System.out.println(data.get(3));

}
}
