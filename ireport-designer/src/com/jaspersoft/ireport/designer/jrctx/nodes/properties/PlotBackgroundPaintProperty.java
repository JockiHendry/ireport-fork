/*
 * iReport - Visual Designer for JasperReports.
 * Copyright (C) 2002 - 2009 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of iReport.
 *
 * iReport is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * iReport is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with iReport. If not, see <http://www.gnu.org/licenses/>.
 */
package com.jaspersoft.ireport.designer.jrctx.nodes.properties;

import com.jaspersoft.ireport.locale.I18n;
import net.sf.jasperreports.chartthemes.simple.PaintProvider;
import net.sf.jasperreports.chartthemes.simple.PlotSettings;

    
/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public final class PlotBackgroundPaintProperty extends PaintProviderProperty
{
    private final PlotSettings plotSettings;

    @SuppressWarnings("unchecked")
    public PlotBackgroundPaintProperty(PlotSettings plotSettings)
    {
        super(plotSettings);
        this.plotSettings = plotSettings;
    }

    @Override
    public String getName()
    {
        return PlotSettings.PROPERTY_backgroundPaint;
    }

    @Override
    public String getDisplayName()
    {
        return I18n.getString("Global.Property." + getName());
    }

    @Override
    public String getShortDescription()
    {
        return getDisplayName();
    }

    @Override
    public PaintProvider getPaintProvider() 
    {
        return plotSettings.getBackgroundPaint();
    }

    @Override
    public PaintProvider getOwnPaintProvider()
    {
        return plotSettings.getBackgroundPaint();
    }

    @Override
    public PaintProvider getDefaultPaintProvider()
    {
        return null;
    }

    @Override
    public void setPaintProvider(PaintProvider PaintProvider)
    {
        plotSettings.setBackgroundPaint(PaintProvider);
    }

}
