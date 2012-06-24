package com.attask.jenkins;

import hudson.Extension;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.listeners.SCMListener;
import hudson.plugins.git.GitChangeSet;
import hudson.plugins.git.GitChangeSetList;
import hudson.scm.ChangeLogSet;

import java.util.List;

/**
 * User: Joel Johnson
 * Date: 6/23/12
 * Time: 9:35 PM
 */
@Extension
public class GitListener extends SCMListener {
	static {
		new GitListener().register();
	}

	@Override
	public void onChangeLogParsed(AbstractBuild<?, ?> build, BuildListener listener, ChangeLogSet<?> changelog) throws Exception {
		if(changelog instanceof GitChangeSetList) {
			List<GitChangeSet> logs = ((GitChangeSetList) changelog).getLogs();
			if(logs != null && !logs.isEmpty()) {
				GitChangeSet latest = logs.get(logs.size() -1);
				build.addAction(new GitEnvironmentAction(latest));
			}
		}
	}
}
