package com.rule.ribbon;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class RandomRule_ZY extends AbstractLoadBalancerRule {

	private int total = 0; // 总共被调用的次数
	private int currentIndex = 0; // 当前提供服务的机器号

	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			return null;
		}
		Server server = null;

		while (server == null) {
			if (Thread.interrupted()) {
				return null;
			}
			List<Server> upList = lb.getReachableServers();
			List<Server> allList = lb.getAllServers();

			int serverCount = allList.size();
			if (serverCount == 0) {// 如果当前注册中心中的服务为空，那么就直接返回null
				return null;
			}

//            int index = chooseRandomInt(serverCount);
//            server = upList.get(index);

			if (total < 5) {
				server = upList.get(currentIndex);
				total++;
			} else {
				total = 0;
				currentIndex++;
				if (currentIndex >= upList.size()) {
					currentIndex = 0;
				}
			}

			if (server == null) {
				/*
				 * The only time this should happen is if the server list were somehow trimmed.
				 * This is a transient condition. Retry after yielding.
				 */
				Thread.yield();
				continue;
			}

			if (server.isAlive()) {
				return (server);
			}

			// Shouldn't actually happen.. but must be transient or a bug.
			server = null;
			Thread.yield();
		}

		return server;

	}

	protected int chooseRandomInt(int serverCount) {
		return ThreadLocalRandom.current().nextInt(serverCount);
	}

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		// TODO Auto-generated method stub
		
	}

}
