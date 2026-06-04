#!/bin/bash

# Branch Protection Setup Script for EventSphere Main Branch
# This script applies branch protection rules using GitHub CLI
# 
# Prerequisites:
# - GitHub CLI (gh) installed and authenticated
# - Admin access to the repository
# 
# Usage: ./setup-branch-protection.sh <owner>/<repo>
# Example: ./setup-branch-protection.sh parnik1989/EventSphere

set -e

REPO=${1:-}

if [ -z "$REPO" ]; then
    echo "Usage: $0 <owner>/<repo>"
    echo "Example: $0 parnik1989/EventSphere"
    exit 1
fi

echo "Setting up branch protection rules for $REPO/main..."

# Apply branch protection rules
gh api \
  --method PUT \
  repos/$REPO/branches/main/protection \
  --input - << 'EOF'
{
  "required_status_checks": {
    "strict": true,
    "contexts": ["build"]
  },
  "enforce_admins": true,
  "required_pull_request_reviews": {
    "require_code_owner_reviews": true,
    "required_approving_review_count": 1,
    "dismiss_stale_reviews": true,
    "dismissal_restrictions": {
      "users": ["parnik1989"]
    }
  },
  "restrictions": null,
  "allow_force_pushes": false,
  "allow_deletions": false,
  "required_conversation_resolution": true
}
EOF

echo "✅ Branch protection rules applied successfully!"
echo ""
echo "Configuration Summary:"
echo "- Branch: main"
echo "- Code updates: ONLY via PR merge (no direct commits)"
echo "- PR Approvals: Required from parnik1989 (code owner)"
echo "- Can approve PRs: parnik1989"
echo "- Can dismiss reviews: parnik1989"
echo "- Requires status checks: Yes (build must pass)"
echo "- Enforce on admins: Yes"
echo "- Allow force pushes: No"
echo "- Allow deletions: No"
