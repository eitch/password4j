package org.password4j;

public class Hash
{
    private static final String EMPTY = "";

    private String result = EMPTY;

    private String salt = EMPTY;

    private HashingStrategy hashingStrategy;

    private Hash()
    {
        //
    }

    public Hash(HashingStrategy hashingStrategy, String salt)
    {
        this.hashingStrategy = hashingStrategy;
        this.salt = salt;
    }

    public Hash(HashingStrategy hashingStrategy, String result, String salt)
    {
        this(hashingStrategy, salt);
        this.result = result;
    }

    public String getResult()
    {
        return result;
    }

    public String getSalt()
    {
        return salt;
    }

    @Override
    public String toString()
    {
        return hashingStrategy.getClass().getSimpleName() + "[" + salt + " - " + result + "]";
    }

    public boolean check(String plain)
    {
        if (plain == null)
        {
            return false;
        }

        return this.hashingStrategy.check(plain, this.getResult());
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null || !this.getClass().equals(obj.getClass()))
        {
            return false;
        }

        Hash otherHash = (Hash) obj;
        return this.result.equals(otherHash.result) && this.salt.equals(otherHash.salt);
    }
}