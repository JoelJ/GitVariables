package com.attask.jenkins;

import hudson.EnvVars;
import hudson.model.AbstractBuild;
import hudson.model.EnvironmentContributingAction;

/**
 * User: Joel Johnson
 * Date: 6/23/12
 * Time: 9:40 PM
 */
public abstract class EnvironmentBaseAction implements EnvironmentContributingAction{
	public abstract void buildEnvVars(AbstractBuild<?, ?> build, EnvVars env);

	public String getIconFileName() {
		return null;
	}

	public String getDisplayName() {
		return null;
	}

	public String getUrlName() {
		return null;
	}
}
