package DistributionLib;

/**
 * A generic DistributionLib.Generator class which delegates its DistributionLib.Seedable ability to a <code>DistributionLib.Distributions</code> object.
 */
public abstract class Generator implements Seedable {
    protected Distributions distrib;
    Generator () { distrib = new Distributions(); }
    Generator (long seed) { distrib = new Distributions(seed); }
    
    // ----- implements DistributionLib.Seedable { -----
    public void setSeed(long seed) { distrib.source.setSeed(seed); }
    public long getSeed() { return distrib.source.getSeed(); }
    public void reseed() { distrib.source.reseed(); }
    // ----- } implements DistributionLib.Seedable -----
}
