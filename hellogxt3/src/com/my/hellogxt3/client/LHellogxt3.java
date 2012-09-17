package com.my.hellogxt3.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import com.sencha.gxt.core.client.Style.LayoutRegion;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LHellogxt3 implements EntryPoint {
	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	  public Widget asWidget() {
		  
		    final BorderLayoutContainer con = new BorderLayoutContainer();
		    con.setBorders(true);
		 
		    final ContentPanel north = new ContentPanel();
		    final ContentPanel west = new ContentPanel();
		    final ContentPanel center = new ContentPanel();
		    center.setHeadingText("BorderLayout Example");
		 
		    final FlexTable table = new FlexTable();
		    table.getElement().getStyle().setProperty("margin", "10px");
		    table.setCellSpacing(8);
		    table.setCellPadding(4);
		 
		    for (int i = 0; i < LayoutRegion.values().length; i++) {
		    	
		      System.out.println("---"+i);
		      
		      final LayoutRegion r = LayoutRegion.values()[i];
		      if (r == LayoutRegion.CENTER) {
		        continue;
		      }
		 
		      final SelectHandler handler = new SelectHandler() {
		 
		        @Override
		        public void onSelect(final SelectEvent event) {
		          final TextButton btn = (TextButton)event.getSource();
		          final String txt = btn.getText();
		          if (txt.equals("Expand")) {
		            con.expand(r);
		          } else if (txt.equals("Collapse")) {
		            con.collapse(r);
		          } else if (txt.equals("Show")) {
		            con.show(r);
		          } else {
		            con.hide(r);
		          }
		        }
		      };
		 
		      table.setHTML(i, 0, "<div style='font-size: 12px; width: 100px'>" + r.name() + ":</span>");
		      table.setWidget(i, 1, new TextButton("---Expand---", handler));
		      table.setWidget(i, 2, new TextButton("Collapse---lihong", handler));
		      table.setWidget(i, 3, new TextButton("Show", handler));
		      table.setWidget(i, 4, new TextButton("Hide", handler));
		    }
		 
		    center.setResize(false);
		    center.add(table);
		 
		    final ContentPanel east = new ContentPanel();
		    final ContentPanel south = new ContentPanel();
		 
		    final BorderLayoutData northData = new BorderLayoutData(100);
		    northData.setMargins(new Margins(5));
		    northData.setCollapsible(true);
		    northData.setSplit(true);
		 
		    final BorderLayoutData westData = new BorderLayoutData(150);
		    westData.setCollapsible(true);
		    westData.setSplit(true);
		    westData.setCollapseMini(true);
		    westData.setMargins(new Margins(0, 5, 0, 5));
		 
		    final MarginData centerData = new MarginData();
		 
		    final BorderLayoutData eastData = new BorderLayoutData(150);
		    eastData.setMargins(new Margins(0, 5, 0, 5));
		    eastData.setCollapsible(true);
		    eastData.setSplit(true);
		 
		    final BorderLayoutData southData = new BorderLayoutData(100);
		    southData.setMargins(new Margins(5));
		    southData.setCollapsible(true);
		    southData.setCollapseMini(true);
		 
		    con.setNorthWidget(north, northData);
		    con.setWestWidget(west, westData);
		    con.setCenterWidget(center, centerData);
		    con.setEastWidget(east, eastData);
		    con.setSouthWidget(south, southData);
		 
		    final SimpleContainer simple = new SimpleContainer();
		    
		    simple.add(con, new MarginData(0));
		 
		    return simple;
		  }	
	
	@Override
	public void onModuleLoad() {
		System.out.println("111111");
//		 final Widget con = asWidget();
//		    final Viewport viewport = new Viewport();
//		    viewport.setPosition(-10,-10);
//		    viewport.add(con);
//		 RootPanel.get().add(viewport);
	}
}
