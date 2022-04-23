package baseClass;

import org.testng.annotations.Test;

public class SecondParallelTest extends BaseParallel{
	
	@Test
	public void firstExecution() throws InterruptedException {
		ParallelTestMethods parallelTests = new ParallelTestMethods(getDriver());
		parallelTests.secondTest();
	}

}
