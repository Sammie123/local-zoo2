import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

  @Test
  public void stylist_instantiatesTrue_true() {
    Stylist testStylist = new Stylist("Lincoln");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getName_stylistWithName_Lincoln() {
    Stylist testStylist = new Stylist("Lincoln");
    assertEquals("Lincoln", testStylist.getName());
  }

  @Test
  public void all_returnsAllInstances_true() {
    Stylist firstStylist = new Stylist("Lincoln");
    Stylist secondStylist = new Stylist("Molly");
    assertEquals(true, Stylist.all().contains(firstStylist));
    assertEquals(true, Stylist.all().contains(secondStylist));
  }

  @Test
  public void getId_styistGetId_1() {
    Stylist testStylist = new Stylist("Lincoln");
    assertEquals(1, testStylist.getId());
  }

  @Test
  public void find_returnsSameId_secondStylist() {
    Stylist firstStylist = new Stylist("Lincoln");
    Stylist secondStylist = new Stylist("Molly");
    assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
  }




}
