package org.vaadin.smartgwt.client.ui.toolbar;

import org.vaadin.smartgwt.client.ui.layout.VMasterContainer;
import org.vaadin.smartgwt.client.ui.utils.PainterHelper;

import com.google.gwt.user.client.Element;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.UIDL;

public class VToolStripButton extends ToolStripButton implements Paintable
{
	public static final String CLICK_EVENT_IDENTIFIER = "click";

	protected String paintableId;
	protected ApplicationConnection client;

	@Override
	public Element getElement()
	{
		return VMasterContainer.getDummy();
	}

	public VToolStripButton()
	{
		super();

		addClickHandler(new ClickHandler()
			{
				@Override
				public void onClick(com.smartgwt.client.widgets.events.ClickEvent event)
				{
					String button = "left click";
					client.updateVariable(paintableId, CLICK_EVENT_IDENTIFIER, button, true);
				}
			});
	}

	@Override
	public void updateFromUIDL(UIDL uidl, ApplicationConnection client)
	{
		this.client = client;
		paintableId = uidl.getId();

		PainterHelper.updateSmartGWTComponent(client, this, uidl);
	}

}