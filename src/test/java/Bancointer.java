import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bancointer {

	
	WebDriver driver;
	@Before
	public void setUp() throws Exception {
		
		// codigo para inidicar o navegador
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		// comando para chamar o driver dentro do before
		driver = new ChromeDriver();
		
		driver.get("https://www.4devs.com.br/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#wrapper-content > div:nth-child(1) > div:nth-child(3) > a > div.card-img.card--xl-img > img")).click();
		driver.findElement(By.cssSelector("#bt_gerar_pessoa")).click();
		
		Thread.sleep(3000);
		
		String nome = driver.findElement(By.id("nome")).getText();
		String telefone = driver.findElement(By.id("telefone_fixo")).getText();
		String email = driver.findElement(By.id("email")).getText();
		String cpf = driver.findElement(By.id("cpf")).getText();
		String data = driver.findElement(By.id("data_nasc")).getText();
		
		driver.quit();
		
		driver = new ChromeDriver();
		
		// comando para indicar URL
		driver.get("https://www.bancointer.com.br/");
		
		//comando para maximixar a tela
		driver.manage().window().maximize();
		
		
		//comando para interagir com o elemento
		
		driver.findElement(By.cssSelector("#gatsby-focus-wrapper > div > header > section > div > div > div > div > div.styles__LogoNIcons-sc-1gbjc3e-6.gjJzHM > div.styles__SearchNFlags-sc-1gbjc3e-8.yVPnY > div.styles__ButtonsWrapper-sc-1gbjc3e-9.PKrxs > button:nth-child(1)")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("nome")).sendKeys(nome);
		driver.findElement(By.id("celular")).sendKeys(telefone);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.id("cpf")).sendKeys(cpf);
		driver.findElement(By.id("dataNascimento")).sendKeys(data);
		driver.findElement(By.cssSelector("body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center > div > div:nth-child(2) > form > div > div:nth-child(6) > div > label")).click();
		driver.findElement(By.cssSelector("body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center > div > div:nth-child(2) > form > div > div.col-12.text-center > div.d-none.d-md-block > button")).click();
		
	}

	
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		Thread.sleep(3000);
		String texto = driver.findElement(By.cssSelector("body > div.style__ModalContent-wuavw4-0.hOXgJK > div.style__Container-sc-138k8xa-0.dlLgSU.d-flex.align-items-center.sent > div > p")).getText();
		System.out.println(texto);
		assertEquals("Prontinho! Recebemos os seus dados.", texto);
	}

}
