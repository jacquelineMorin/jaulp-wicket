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
package de.alpharogroup.wicket.behaviors;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.model.Model;

/**
 * The Class {@link DisplayNoneBehavior}.
 */
public class DisplayNoneBehavior extends AttributeModifier
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Factory method to create a new {@link DisplayNoneBehavior} object.
	 *
	 * @return the new {@link DisplayNoneBehavior} object.
	 */
	public static DisplayNoneBehavior of()
	{
		return new DisplayNoneBehavior();
	}

	/**
	 * Instantiates a new {@link DisplayNoneBehavior}.
	 */
	public DisplayNoneBehavior()
	{
		super("style", Model.of("display: none"));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isTemporary(final Component component)
	{
		return true;
	}
}