package forgprod.hullmods;

import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.fleet.FleetMemberAPI;
import com.fs.starfarer.api.ui.TooltipMakerAPI;

import forgprod.abilities.conversion.support.ProductionConstants;
import forgprod.abilities.conversion.support.ProductionType;
import forgprod.abilities.modules.FleetwideModuleManager;
import forgprod.abilities.modules.dataholders.ProductionModule;
import forgprod.hullmods.base.BaseProductionHullmod;

import java.util.ArrayList;

/**
 * @author Ontheheavens
 * @since 06.12.2022
 */

@SuppressWarnings("unused")
public class HeavyIndustryModule extends BaseProductionHullmod {

    @Override
    public String modID() {
        return "Production logistics Heavy";
    }
    @Override
    public void addCapacitySection(TooltipMakerAPI tooltip, ShipAPI ship) {
        if (!super.addAvailableCapacities(tooltip, ship)) {
            super.addCapacityPanels(tooltip, ship, true, ProductionType.SUPPLIES_PRODUCTION,
                    ProductionType.MACHINERY_PRODUCTION);
        }
    }
    @Override
    public ProductionModule getSpecificModule(FleetMemberAPI member) {
        if (member == null) return null;
        ArrayList<ProductionModule> modules = FleetwideModuleManager.getInstance().getSpecificModule(member);
        if(modules == null) return null;
        for (ProductionModule a : modules){
            if (a.getHullmodId().equals(ProductionConstants.HEAVY_INDUSTRY_MODULE)) return a;
        }
        return null;
    }

}
