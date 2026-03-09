package exercise5_1.models;

public class TestUser {
    private String username;
    private String password;
    private String role;
    private boolean active;

    private TestUser(UserBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.role = builder.role;
        this.active = builder.active;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

        public static class UserBuilder {

            private String username;
            private String password;
            private String role = "USER";
            private boolean active = true;

            public UserBuilder username(String username) {
                this.username = username;
                return this;
            }

            public UserBuilder password(String password) {
                this.password = password;
                return this;
            }

            public UserBuilder role(String role) {
                this.role = role;
                return this;
            }

            public UserBuilder active(boolean active) {
                this.active = active;
                return this;
            }

            public TestUser build() {
                return new TestUser(this);
            }
        }
}
