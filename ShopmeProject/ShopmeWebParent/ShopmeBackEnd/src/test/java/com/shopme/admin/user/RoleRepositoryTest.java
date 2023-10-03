package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) /// esto es para cuando se teste el proyecto se haga sobre una base de datos real
@Rollback(false)
public class RoleRepositoryTest {
	
	@Autowired
	private RoleRepository repo;
	
	@Test
	public void testCreateFirstRole () {
		Role roleAdmin = new Role("Admin", "gestionar todo");
		Role savedRole =  repo.save(roleAdmin);
		assertThat(savedRole.getId()).isGreaterThan(0);  /// significa que el objeto Role ha sido persistido en la base de datos
		
	}
	
	@Test
	public void testCreateRestRoles() {
		Role roleSalesperson = new Role("Salesperson", "gestionar el precio del producto, los clientes, el envío, los pedidos y el informe de ventas");
		
		Role roleEditor = new Role("Editor", "gestionar categorías, marcas, productos, artículos y menús");
		
		Role roleShipper = new Role("Shipper","ver productos, ver pedidos y actualizar el estado del pedido");
		
		Role roleAssistant = new Role("Assistant", "gestionar preguntas y reseñas");
		
		repo.saveAll(List.of(roleSalesperson, roleEditor, roleShipper, roleAssistant));
		
		
	}
	
}
