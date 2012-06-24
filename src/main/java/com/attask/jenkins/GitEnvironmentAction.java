package com.attask.jenkins;

import hudson.EnvVars;
import hudson.model.AbstractBuild;
import hudson.model.Action;
import hudson.plugins.git.GitChangeSet;

/**
 * User: Joel Johnson
 * Date: 6/23/12
 * Time: 9:41 PM
 */
public class GitEnvironmentAction extends EnvironmentBaseAction {
	private final GitChangeSet gitChangeSet;
	public GitEnvironmentAction(GitChangeSet gitChangeSet) {
		this.gitChangeSet = gitChangeSet;
	}

	@Override
	public void buildEnvVars(AbstractBuild<?, ?> build, EnvVars env) {
		env.put("GIT_AUTHOR", gitChangeSet.getAuthorName());
		env.put("GIT_COMMENT", gitChangeSet.getComment().trim());
		env.put("GIT_COMMENT_ANNOTATED", gitChangeSet.getCommentAnnotated());
		env.put("GIT_DATE", gitChangeSet.getDate());
		env.put("GIT_PARENT", gitChangeSet.getParentCommit());
		env.put("GIT_REVISION", gitChangeSet.getRevision());
		env.put("GIT_REVISION_SHORT", gitChangeSet.getRevision().substring(0, 7));
	}
}
