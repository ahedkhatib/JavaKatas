package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RoundRobinLoadBalancerTest {

    @Test
    void testRoundRobinBalancer(){
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("192.168.0.1"));
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("192.168.0.2"));
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("192.168.0.3"));


        assertEquals("192.168.0.1", loadBalancer.routeRequest().toString());
        assertEquals("192.168.0.2", loadBalancer.routeRequest().toString());
        assertEquals("192.168.0.3", loadBalancer.routeRequest().toString());
        assertEquals("192.168.0.1", loadBalancer.routeRequest().toString());

        loadBalancer.removeServer(new RoundRobinLoadBalancer.IP("192.168.0.2"));
        assertEquals("192.168.0.3", loadBalancer.routeRequest().toString());
        assertEquals("192.168.0.1", loadBalancer.routeRequest().toString());
    }

    @Test
    void testRemoveUnknownServer(){
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("192.168.0.1"));
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("192.168.0.2"));
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("192.168.0.3"));

        loadBalancer.removeServer(new RoundRobinLoadBalancer.IP("192.169.0.2"));

        assertEquals("192.168.0.1", loadBalancer.routeRequest().toString());
        assertEquals("192.168.0.2", loadBalancer.routeRequest().toString());
        assertEquals("192.168.0.3", loadBalancer.routeRequest().toString());
    }

    @Test
    void testNullServers(){
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();
        assertNull(loadBalancer.routeRequest());
    }

    @Test
    void testDuplicateServer() {
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("192.168.0.1"));
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("192.168.0.1"));
        loadBalancer.routeRequest();
        loadBalancer.removeServer(new RoundRobinLoadBalancer.IP("192.168.0.1"));
        assertEquals("192.168.0.1", loadBalancer.routeRequest().toString());
    }

    @Test
    void testEmptyAfterRemove() {
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("192.168.0.1"));
        loadBalancer.removeServer(new RoundRobinLoadBalancer.IP("192.168.0.1"));

        assertNull(loadBalancer.routeRequest());
    }

}
