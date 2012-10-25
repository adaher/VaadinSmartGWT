package org.vaadin.smartgwt.server;

import org.vaadin.smartgwt.server.layout.MasterContainer;

public class WindowFactory {
	private final MasterContainer masterContainer;

	public WindowFactory(MasterContainer masterContainer) {
		this.masterContainer = masterContainer;
	}

	public Window newWindow() {
		return new Window(masterContainer);
	}

	public Window newModalWindow() {
		Window window = new Window(masterContainer);
		window.setCanDragResize(true);
		window.setAutoCenter(true);
		window.setShowMinimizeButton(false);
		window.setShowMaximizeButton(false);
		window.setIsModal(true);
		window.setShowModalMask(true);
		window.setAutoSize(true);
		return window;
	}
}
