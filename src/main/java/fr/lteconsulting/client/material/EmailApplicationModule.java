package fr.lteconsulting.client.material;

import fr.lteconsulting.angular2gwt.client.interop.ng.material.button.MdButtonModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.buttonToggle.MdButtonToggleModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.card.MdCardModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.checkbox.MdCheckboxModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.core.MdRippleModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.core.OverlayModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.core.PortalModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.core.RtlModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.gridList.MdGridListModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.icon.MdIconModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.input.MdInputModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.list.MdListModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.menu.MdMenuModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.progressBar.MdProgressBarModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.progressCircle.MdProgressCircleModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.radio.MdRadioModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.sidenav.MdSidenavModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.slideToggle.MdSlideToggleModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.slider.MdSliderModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.tabs.MdTabsModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.toolbar.MdToolbarModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.material.tooltip.MdTooltipModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.platformBrowser.BrowserModule;
import fr.lteconsulting.angular2gwt.ng.core.NgModule;
import jsinterop.annotations.JsType;

@NgModule(
		imports = {
				BrowserModule.class,

				MdButtonModule.class,
				MdButtonToggleModule.class,
				MdCardModule.class,
				MdCheckboxModule.class,
				MdGridListModule.class,
				MdIconModule.class,
				MdInputModule.class,
				MdListModule.class,
				MdMenuModule.class,
				MdProgressBarModule.class,
				MdProgressCircleModule.class,
				MdRadioModule.class,
				MdRippleModule.class,
				MdSidenavModule.class,
				MdSliderModule.class,
				MdSlideToggleModule.class,
				MdTabsModule.class,
				MdToolbarModule.class,
				//MdTooltipModule.class,
				OverlayModule.class,
				PortalModule.class,
				RtlModule.class,
		},
		declarations = EmailApplicationComponent.class,
		entryComponents = EmailApplicationComponent.class,
		bootstrap = EmailApplicationComponent.class )
@JsType
public class EmailApplicationModule
{
}
