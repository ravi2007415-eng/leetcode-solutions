class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String p : parts) {
            if (p.equals("") || p.equals(".")) continue;
            if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(p);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.removeLast());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
