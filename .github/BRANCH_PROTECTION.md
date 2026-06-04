# Branch Protection Rules Configuration for EventSphere

This guide explains how to set up branch protection rules for the EventSphere repository's main branch.

## 🔒 Security Model

**Code updates to main can ONLY happen through PR merge by parnik1989.**

- ✅ No direct commits/pushes to main allowed
- ✅ All changes require a pull request
- ✅ PR can only be approved by parnik1989
- ✅ Build must pass before merge
- ✅ All conversations must be resolved before merge

## Quick Setup

### Using GitHub CLI (Recommended)

1. **Install GitHub CLI** if you haven't already:
   ```bash
   brew install gh  # macOS
   ```

2. **Authenticate with GitHub:**
   ```bash
   gh auth login
   ```

3. **Run the setup script:**
   ```bash
   chmod +x .github/scripts/setup-branch-protection.sh
   .github/scripts/setup-branch-protection.sh <owner>/<repo>
   ```
   
   Example:
   ```bash
   .github/scripts/setup-branch-protection.sh parnik1989/EventSphere
   ```

### Using GitHub Web UI (Manual)

1. Go to your repository on GitHub
2. Click **Settings** → **Branches**
3. Under **Branch protection rules**, click **Add rule**
4. Enter `main` as the branch name pattern
5. Enable these settings:
   - ✅ Require a pull request before merging
   - ✅ Require status checks to pass before merging
   - ✅ Require branches to be up to date before merging
   - ✅ Require conversation resolution before merging
   - ✅ Require code owner reviews (requires CODEOWNERS file)
   - ✅ Dismiss stale pull request approvals when new commits are pushed
   - ❌ Allow force pushes
   - ❌ Allow deletions

6. Under "Restrict who can push to matching branches", select your user account (parnik1989)

7. Click **Create**

**Note:** The CODEOWNERS file (`.github/CODEOWNERS`) is already configured to specify parnik1989 as the code owner, which means parnik1989 must approve all PRs.

## Configuration Details

The branch protection rules configured include:

| Setting | Value | Purpose |
|---------|-------|---------|
| Branch Pattern | `main` | Protects the main branch |
| No Direct Commits | Enforced | All code must go through pull requests |
| Require PR Approval | Yes (1 approval) | PRs must be approved before merge |
| Code Owner Reviews | Yes | Requires approval from parnik1989 |
| Code Owner Approval | parnik1989 | Only parnik1989 can approve PRs |
| Can Dismiss Reviews | parnik1989 | Only parnik1989 can dismiss reviews |
| Status Checks | build | Build must pass before merging |
| Stale Reviews | Dismiss | Rechecks approvals after new commits |
| Force Pushes | Disabled | Prevents rewriting history |
| Deletions | Disabled | Prevents branch deletion |
| Conversation Resolution | Required | All discussions must be resolved |
| Enforce on Admins | Yes | Rules apply even to repository admins |

## Current CI Workflow

The updated CI workflow (`.github/workflows/ci.yml`) now:
- ✅ Triggers on **commits to any branch** (`push: branches: ['**']`)
- ✅ Triggers on **PR events to main** (`pull_request: branches: [main]`)
- ✅ Runs **build and tests** on JDK 21 with Gradle

## Verifying the Setup

After applying branch protection rules, verify them:

```bash
gh api repos/<owner>/<repo>/branches/main/protection
```

## Troubleshooting

**Issue**: "Not Found" error when running setup script
- **Solution**: Ensure you have admin access and the repo path is correct

**Issue**: Branch protection rules not appearing
- **Solution**: GitHub may cache rules. Refresh the settings page or wait 1-2 minutes

**Issue**: Script permission denied
- **Solution**: Run `chmod +x .github/scripts/setup-branch-protection.sh`
