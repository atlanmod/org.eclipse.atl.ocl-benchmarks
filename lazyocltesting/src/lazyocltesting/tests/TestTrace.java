package lazyocltesting.tests;

public class TestTrace {
	private double[] xtrace;
	private double[] ytrace;
	
	public TestTrace(double[] xtrace, double[] ytrace) {
		super();
		this.xtrace = xtrace;
		this.ytrace = ytrace;
	}

	public double[] getXtrace() {
		return xtrace;
	}

	public void setXtrace(double[] xtrace) {
		this.xtrace = xtrace;
	}

	public double[] getYtrace() {
		return ytrace;
	}

	public void setYtrace(double[] ytrace) {
		this.ytrace = ytrace;
	}
}
