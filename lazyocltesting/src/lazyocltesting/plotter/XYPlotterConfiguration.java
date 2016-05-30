package lazyocltesting.plotter;

public class XYPlotterConfiguration {
	private boolean isShowTitle;
	private boolean isShowXAxis;
	private boolean isShowYAxis;
	private int height;
	private int width;
	
	
	public XYPlotterConfiguration(boolean isShowTitle, boolean isShowXAxis, boolean isShowYAxis, int height,
			int width) {
		super();
		this.isShowTitle = isShowTitle;
		this.isShowXAxis = isShowXAxis;
		this.isShowYAxis = isShowYAxis;
		this.height = height;
		this.width = width;
	}


	public boolean isShowTitle() {
		return isShowTitle;
	}


	public void setShowTitle(boolean isShowTitle) {
		this.isShowTitle = isShowTitle;
	}


	public boolean isShowXAxis() {
		return isShowXAxis;
	}


	public void setShowXAxis(boolean isShowXAxis) {
		this.isShowXAxis = isShowXAxis;
	}


	public boolean isShowYAxis() {
		return isShowYAxis;
	}


	public void setShowYAxis(boolean isShowYAxis) {
		this.isShowYAxis = isShowYAxis;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}
}
