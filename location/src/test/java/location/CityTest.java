package location;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.aroundinfo.project.dao.CityDAO;
import com.aroundinfo.project.model.City;
import com.aroundinfo.project.model.Country;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public class CityTest extends TestCase {
	
	@Autowired
	private CityDAO service;

	@Test
	public void testCity() {
		
      Assert.assertNotNull(service);
        
      Assert.assertTrue(service.getCitysList().size()>0);

      Country country = new Country();
      country.setId(3); // Should be France

      List<City> list = service.getCityListById(country);

      Assert.assertEquals(3, list.size());		
		
	}

}
