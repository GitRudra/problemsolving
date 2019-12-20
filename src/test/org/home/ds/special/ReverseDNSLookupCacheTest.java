package org.home.ds.special;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseDNSLookupCacheTest {

    @Test
    public void testDNSLookUpCacheOne()throws Exception{
        ReverseDNSLookupCache cache = new ReverseDNSLookupCache();
        String dns1 = "74.125.200.106";
        String url1  = "www.google.com";

        String dns2 = "74.125.200.105";
        String url2  = "www.google.in";

        cache.doCache(url1,dns1);
        cache.doCache(url2,dns2);
        String actualUrl = cache.resolveDns(dns1);
        assertEquals(url1,actualUrl);
    }

    @Test
    public void testDNSLookUpCacheTwo() throws Exception{
        ReverseDNSLookupCache cache = new ReverseDNSLookupCache();
        String dns1 = "74.125.200.106";
        String url1  = "www.google.com";

        String dns2 = "74.125.200.105";
        String url2  = "www.google.in";

        cache.doCache(url1,dns1);
        cache.doCache(url2,dns2);
        String actualUrl = cache.resolveDns(dns1);
        assertEquals(url1,actualUrl);
    }

}