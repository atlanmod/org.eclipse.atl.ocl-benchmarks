package lazyocltesting.plotter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.nebula.visualization.xygraph.dataprovider.CircularBufferDataProvider;
import org.eclipse.nebula.visualization.xygraph.figures.IXYGraph;
import org.eclipse.nebula.visualization.xygraph.figures.ToolbarArmedXYGraph;
import org.eclipse.nebula.visualization.xygraph.figures.Trace;
import org.eclipse.nebula.visualization.xygraph.figures.Trace.PointStyle;
import org.eclipse.nebula.visualization.xygraph.figures.XYGraph;
import org.eclipse.nebula.visualization.xygraph.util.SingleSourceHelper2;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class XYPlotter {
	private String graphTitle;
	private IXYGraph xyGraph;
	final Shell shell = new Shell();
	private String savePath;
	private XYPlotterConfiguration conf;
	
	
	public XYPlotter(XYPlotterConfiguration conf, String graphTitle, String savePath) {
		super();
		this.graphTitle = graphTitle;
		this.savePath = savePath;
		this.conf = conf;
		this.initialize();
	}
	
	public void initialize(){
		shell.setSize(conf.getWidth(), conf.getHeight());
	    shell.open();
	    final LightweightSystem lws = new LightweightSystem(shell);
		xyGraph = new XYGraph();
		//ToolbarArmedXYGraph toolbarArmedXYGraph = new ToolbarArmedXYGraph(xyGraph);
		xyGraph.setTitle(this.graphTitle);
		xyGraph.setShowLegend(false);
		xyGraph.setShowTitle(conf.isShowTitle());
		lws.setContents(xyGraph);
	}
	
	public IXYGraph getXyGraph() {
		return xyGraph;
	}

	public void setXyGraph(XYGraph xyGraph) {
		this.xyGraph = xyGraph;
	}

	public CircularBufferDataProvider CreateNewBuffer(int size, double[] xvector, double[] yvector){
		CircularBufferDataProvider traceDataProvider = new CircularBufferDataProvider(false);
		traceDataProvider.setBufferSize(size);		
		traceDataProvider.setCurrentXDataArray(xvector);
		traceDataProvider.setCurrentYDataArray(yvector);
		return traceDataProvider;
	}
	
	public Trace createTrace(IXYGraph xyGraph, String name, int size, double[] xvector, double[] yvector){
		CircularBufferDataProvider traceDataProvider = CreateNewBuffer(size, xvector, yvector);
		Trace trace = new Trace(name, 
				xyGraph.getPrimaryXAxis(), xyGraph.getPrimaryYAxis(), traceDataProvider);
		trace.setPointStyle(PointStyle.NONE);
		return trace;
	}
	
	public void showPlot(Trace trace1, Trace trace2, Boolean save){	
	   //add the trace to xyGraph
	  	xyGraph.addTrace(trace1);
	  	xyGraph.addTrace(trace2);
		xyGraph.getPrimaryXAxis().setVisible(conf.isShowXAxis());
		xyGraph.getPrimaryYAxis().setVisible(conf.isShowYAxis());
		
	  	xyGraph.performAutoScale();
	  	Boolean saved = false;
	  	Image im = null;
	  	
	  	
	  	
	  	Display display = Display.getDefault();
	  	
	    while (!shell.isDisposed()) {
	      im = xyGraph.getImage();
	    	
	      if (!display.readAndDispatch())
	        display.sleep();
	      
	    }
	    
	    if (save){
	    	this.save(im, xyGraph.getTitle());
	    }
	    
	    display.close();
	    shell.dispose();
	}
	
	public void save(Image im, String name){
		final ImageLoader loader = new ImageLoader();
		
		
		loader.data = new ImageData[] { im.getImageData() };
		//final FileDialog dialog = new FileDialog(Display.getDefault().getShells()[0], SWT.SAVE);
		//dialog.setFilterNames(new String[] { "PNG Files", "All Files (*.*)" });
		//dialog.setFilterExtensions(new String[] { "*.png", "*.*" }); // Windows
		
		 File screenCapture = new File(savePath + name + ".png" ); //$NON-NLS-1$
		 try {
			screenCapture.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		System.out.println( "file: " + screenCapture); //$NON-NLS-1$
		loader.save(screenCapture.getAbsolutePath(), SWT.IMAGE_PNG);
	}

	//This is just for testing purposes
	public static void main(String[] args) {
		XYPlotterConfiguration conf = new XYPlotterConfiguration(false, false, false, 200, 300);
	    XYPlotter tn = new XYPlotter(conf, "Title", "");
			
		Trace trace = tn.createTrace(tn.getXyGraph(), "Trace1-XY Plot", 500, 
				new double[]{10, 23, 34, 45, 56, 78, 88, 99},
				new double[]{11, 44, 55, 45, 88, 98, 52, 23});
							
		Trace trace2 = tn.createTrace(tn.getXyGraph(), "Trace2-XY Plot", 500, 
				new double[]{10, 23, 34, 45, 56, 78, 88, 99},
				new double[]{44, 44, 55, 45, 44, 44, 44, 44});
		
		tn.showPlot(trace, trace2, false);
	}

}
