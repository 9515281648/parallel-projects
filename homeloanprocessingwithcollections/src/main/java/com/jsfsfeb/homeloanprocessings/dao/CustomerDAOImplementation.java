package com.jsfsfeb.homeloanprocessings.dao;

import com.jsfsfeb.homeloanprocessings.dto.CustomerInfoBeans;
import com.jsfsfeb.homeloanprocessings.repository.RepositoryStorage;

import lombok.extern.log4j.Log4j;
@Log4j
public class CustomerDAOImplementation implements CustomerDAO {

	public boolean customerApplication(CustomerInfoBeans bean1) {

		for (CustomerInfoBeans bean : RepositoryStorage.dataOfCustomer()) {

			if (bean.getCustomerName().equals(bean1.getCustomerName()) == true) {

				RepositoryStorage.dataOfCustomer().add(bean1);
				log.info(" entered name already exits ");
				return false;
			} else {
				return true;
			}

		}
		return false;
	}
}
