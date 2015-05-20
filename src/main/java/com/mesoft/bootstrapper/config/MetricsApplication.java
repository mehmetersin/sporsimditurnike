package com.mesoft.bootstrapper.config;

import java.util.concurrent.TimeUnit;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

public class MetricsApplication {

	public static void main(String[] args) {

		final MetricRegistry metrics = new MetricRegistry();
		

		final Meter requests = metrics.meter("requests");

		final JmxReporter reporter = JmxReporter.forRegistry(metrics).build();
		reporter.start();

		requests.mark();

	

		 final Histogram responseSizes = metrics.histogram("response-sizes");
		 
			ConsoleReporter re = ConsoleReporter.forRegistry(metrics)
					.convertRatesTo(TimeUnit.SECONDS)
					.convertDurationsTo(TimeUnit.MILLISECONDS).build();
			re.start(1, TimeUnit.SECONDS);

		try {
			Thread.sleep(10000);
			requests.mark();
			responseSizes.update(10);
			Thread.sleep(10000);
			requests.mark();
			responseSizes.update(90);
			Thread.sleep(10000);
			requests.mark();
			responseSizes.update(80);
			Thread.sleep(10000);
			requests.mark();
			responseSizes.update(70);
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}