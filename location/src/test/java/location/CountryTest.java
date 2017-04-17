package location;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.aroundinfo.project.dao.CountryDAO;
import com.aroundinfo.project.model.Country;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public class CountryTest extends TestCase {
	
	@Autowired
	private CountryDAO service;

	@Test
	public void testCountry() {
		
	  Assert.assertNotNull(service);

      long count = service.getCountryList().size();

      Assert.assertTrue(count > 0);

      List<Country> countries = service.getCountryList();

      Assert.assertEquals((int) count, countries.size());		
		
	}
	
    @Test
    public void testFindOneCountry() {

        Assert.assertNotNull(service);

        List<Country> countries = service.getCountryListByName("Uni");

        Assert.assertEquals(1, countries.size());

    }

}
