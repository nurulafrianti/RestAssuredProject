package DataDriven;

import org.testng.annotations.DataProvider;


public class DataForTest {

    @DataProvider(name = "DataForPost")
    public Object[][] dataForPost() {
        return new Object[][] {
                {"Raffi", "Ahmad", 1},
                {"Nagita", "Slavina", 2},
        };
    }

    @DataProvider (name = "DeleteData")
    public Object[] dataForDelete() {
        return new Object[] {
                11
        };
    }


}
