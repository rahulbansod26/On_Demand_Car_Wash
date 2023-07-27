package com.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.admin.model.WasherLeaderboard;
import com.admin.model.Washpacks;
import com.admin.repository.AdminRepository;
import com.admin.repository.WasherLeaderboardRepository;
import com.admin.service.AdminServiceImpl;


@SpringBootTest
@RunWith(SpringRunner.class)
class CarwashManagementApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private AdminServiceImpl adminService;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private WasherLeaderboardRepository washerLeaderboardRepository;

	@Test
	public void addWashpacks(){

		Washpacks washpacks = new Washpacks(1,"Premium",23000,"For premium cars");
		when(adminService.addNewWashPack(washpacks)).thenReturn(washpacks);
		assertEquals(washpacks,adminService.addNewWashPack(washpacks));
	}

	@Test
	public void getPack(){

		Washpacks washpacks = new Washpacks(1,"Premium",23000,"For premium cars");
		when(adminService.findByName("Deluxe")).thenReturn(washpacks);

	}

	@Test
	void washerLeaderboard() {
		when(adminService.getWasherLeaderboard()).thenReturn(new ArrayList<>());
	}


@Test
public void testGetAllPacks() {
    Washpacks pack1 = new Washpacks();
    pack1.setId(1);
    pack1.setPackName("Basic Pack");
    pack1.setAmount(10.0);
    pack1.setDescription("Basic washing pack");

    Washpacks pack2 = new Washpacks();
    pack2.setId(2);
    pack2.setPackName("Premium Pack");
    pack2.setAmount(20.0);
    pack2.setDescription("Premium washing pack");

    List<Washpacks> packs = Arrays.asList(pack1, pack2);

    when(adminRepository.findAll()).thenReturn(packs);

    List<Washpacks> allPacks = adminService.getAllPacks();

    assertEquals(packs.size(), allPacks.size());
    assertEquals(pack1, allPacks.get(0));
    assertEquals(pack2, allPacks.get(1));
    verify(adminRepository, times(1)).findAll();
}
//@Before
//public void setUp() {
//    adminRepository = mock(AdminRepository.class);
//    adminService = new AdminServiceImpl(adminRepository);
//}

@Test
public void testUpdateWashPack() {
	Washpacks pack = new Washpacks();
    pack.setId(1);
    pack.setPackName("Basic Pack");
    pack.setAmount(10);
    pack.setDescription("Basic washing pack");

    when(adminRepository.save(any(Washpacks.class))).thenReturn(pack);

    Washpacks updatedPack = adminService.updateWashPack(pack);

    assertEquals(pack, updatedPack);
    verify(adminRepository, times(1)).save(pack);
}

@Test
public void testDeleteById() {
    int packId = 1;

    adminService.deleteById(packId);

    verify(adminRepository, times(1)).deleteById(packId);
}

@Test
public void testGetWasherLeaderboard() {
    WasherLeaderboard leaderboard1 = new WasherLeaderboard();
    leaderboard1.setRank(1);
    leaderboard1.setWasherName("John");
    leaderboard1.setWaterSavedInLiters(100);
    leaderboard1.setWorkingHrs(8);

    WasherLeaderboard leaderboard2 = new WasherLeaderboard();
    leaderboard2.setRank(2);
    leaderboard2.setWasherName("Jane");
    leaderboard2.setWaterSavedInLiters(150);
    leaderboard2.setWorkingHrs(6);

    List<WasherLeaderboard> leaderboard = Arrays.asList(leaderboard1, leaderboard2);

    when(washerLeaderboardRepository.findAll()).thenReturn(leaderboard);

    List<WasherLeaderboard> result = adminService.getWasherLeaderboard();

    assertEquals(leaderboard.size(), result.size());
    assertEquals(leaderboard.get(0), result.get(0));
    assertEquals(leaderboard.get(1), result.get(1));
    verify(washerLeaderboardRepository, times(1)).findAll();
}
	
}
