import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Test
  public void Client_instantiatesTrue_true() {
    Client myClient = new Client("Molly");
    assertEquals(true, myClient instanceof Client);
  }

  @Test
  public void Task_instantiatesWithName_String() {
    Client myClient = new Client("Molly");
    assertEquals("Molly", myClient.getName());
  }

}
