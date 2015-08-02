/**
 * Copyright (C) 2010 Asterios Raptis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.alpharogroup.wicket.components.i18n.dropdownchoice;

import java.util.List;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.IModel;

import de.alpharogroup.wicket.components.labeled.LabeledFormComponentPanel;

public class LocalizedDropdownChoicePanel<T> extends LabeledFormComponentPanel<T>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	private final DropDownChoice<T> dropdownChoice;

	public LocalizedDropdownChoicePanel(final String id, final IModel<T> model,
		final IModel<String> labelModel, final List<T> enumValues)
	{
		super(id, model, labelModel);

		dropdownChoice = new LocalisedDropDownChoice<T>("dropdownChoice", model, enumValues);
		add(dropdownChoice);

		add(feedback = newComponentFeedbackPanel("feedback", dropdownChoice));

		final String markupId = dropdownChoice.getMarkupId();
		add(label = newLabel("label", markupId, getLabel()));

		// Add bootstrap css...
		getLabelComponent().add(new AttributeAppender("class", "control-label"));

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void convertInput()
	{
		setConvertedInput(dropdownChoice.getConvertedInput());
	}

	public DropDownChoice<T> getDropdownChoice()
	{
		return dropdownChoice;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getInput()
	{
		return dropdownChoice.getInput();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onBeforeRender()
	{
		dropdownChoice.setRequired(isRequired());
		super.onBeforeRender();
	}

}
