package forer.ApprovedDrugs;

import java.util.List;

public class DrugFeed {

    private List<Molecule> molecules;
    private PageInfo page_meta;

    public List<Molecule> getMolecules() {
        return molecules;
    }

    public final PageInfo getPage_meta() {
        return page_meta;
    }

    public Molecule getMolecule(String id) {
        for (Molecule mol : molecules) {
            if (mol.getMolId() == id) {
                return mol;
            }
        }
        return null;
    }

}

