package com.example.animal;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.animal.model.Animal;
import com.example.animal.model.Owner;
import com.example.animal.model.Playground;
import com.example.animal.model.PlaygroundAnimals;
import com.example.animal.model.Product;
import com.example.animal.model.Warranty;
import com.example.animal.repository.AnimalRepository;
import com.example.animal.repository.OwnerRepository;
import com.example.animal.repository.PlaygroundAnimalsRepository;
import com.example.animal.repository.PlaygroundRepository;
import com.example.animal.repository.ProductRepository;
import com.example.animal.repository.WarrantyRepository;

@SpringBootTest
class AnimalApplicationTests {
	@Autowired
	AnimalRepository animalRepository;
	@Autowired
	OwnerRepository ownerRepository;
	@Autowired
	PlaygroundAnimalsRepository playgroundAnimalsRepository;
	@Autowired
	PlaygroundRepository playgroundRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	WarrantyRepository warrantyRepository;

	// 1. '중형견 사료'를 사준 사람의 이름은?
	@Test
	void 문제1() {
		Product p = productRepository.findByName("중형견 사료");
		System.out.println(p.getAnimal().getOwner().getName());
	}

	// 2. '얼룩이'의 주인과 사용하고 있는 물품은?
	@Test
	void 문제2() {
		Animal a = animalRepository.findByName("얼룩이");
		List<Product> p = productRepository.findByAnimal(a);
		System.out.println(a.getOwner().getName());
		for (Product pd : p) {
			System.out.println(pd.getName());
		}
	}

	// 3. '홍길동'이 반려동물에게 사준 모든 물품은?
	@Test
	void 문제3() {
		Owner o = ownerRepository.findByName("홍길동");
		List<Animal> a = animalRepository.findByOwner(o);
		for (int i = 0; i < a.size(); i++) {
			List<Product> p = productRepository.findByAnimal(a.get(i));
			for (Product pd : p) {
				System.out.println(pd.getName());
			}
		}
	}

	// 4. '용인 처인구'에 위치한 놀이터에 방문한 동물의 이름과 나이, 주인의 이름은?
	// playground - playground_animals - animal - owner
	@Test
	void 문제4() {
		Playground pg = playgroundRepository.findByAddress("용인 처인구");
		List<PlaygroundAnimals> pga = playgroundAnimalsRepository.findByPlayground(pg);
		for (PlaygroundAnimals pa : pga) {
			String name = pa.getAnimal().getName();
			Integer age = pa.getAnimal().getAge();
			String on = pa.getAnimal().getOwner().getName();
			System.out.println(name + "/" + age + "/" + on);
		}
	}

	// 5. '목줄'을 사용하는 동물이 방문한 놀이터의 이름과 전화번호는?
	@Test
	void 문제5() {
		Product p = productRepository.findByName("목줄");
		Animal a = p.getAnimal();
		List<PlaygroundAnimals> pga = playgroundAnimalsRepository.findByAnimal(a);
		for (PlaygroundAnimals pa : pga) {
			String name = pa.getPlayground().getName();
			String tel = pa.getPlayground().getTel();
			System.out.println(name + "/" + tel);
		}
	}

	// 6. 모델명이 'CS01'인 보증서를 가지고 있는 주인의 이름은?
	@Test
	void 문제6() {
		Warranty w = warrantyRepository.findByModelNm("CS01");
		List<Product> p = productRepository.findByWarranty(w);
		for (Product pd : p) {
			System.out.println(pd.getAnimal().getOwner().getName());
		}
	}

}
