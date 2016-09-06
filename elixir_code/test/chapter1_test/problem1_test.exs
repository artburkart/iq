defmodule ElixirCode.Chapter1Test.Problem1Test do
  use ExUnit.Case
  use ExUnit.Parameterized

  alias ElixirCode.Chapter1.Problem1, as: Problem1

  test_with_params "bitmethod, boolmethod, sortmethod",
    fn (str, method, expected) ->
      assert (apply Problem1, method, [str]) == expected
    end do
      [
        {"", :bitmethod, false},
        {"", :boolmethod, false},
        {"", :sortmethod, false},
        {"a", :bitmethod, true},
        {"a", :boolmethod, true},
        {"a", :sortmethod, true},
        {"ab", :bitmethod, true},
        {"ab", :boolmethod, true},
        {"ab", :sortmethod, true},
        {"aba", :bitmethod, false},
        {"aba", :boolmethod, false},
        {"aba", :sortmethod, false},
        {"aaba", :bitmethod, false},
        {"aaba", :boolmethod, false},
        {"aaba", :sortmethod, false},
        {"baa", :bitmethod, false},
        {"baa", :boolmethod, false},
        {"baa", :sortmethod, false},
        {"abcdefghijklmnopqrstuvwxyz{|}~_`", :bitmethod, true},
        {"abcdefghijklmnopqrstuvwxyz{|}~_`", :boolmethod, true},
        {"abcdefghijklmnopqrstuvwxyz{|}~_`", :sortmethod, true},
        {"abcdefghijklmnopqrstuvwxyz{|}~_`abcdefghijklmnopqrstuvwxyz{|}~_`", :bitmethod, false},
        {"abcdefghijklmnopqrstuvwxyz{|}~_`abcdefghijklmnopqrstuvwxyz{|}~_`", :boolmethod, false},
        {"abcdefghijklmnopqrstuvwxyz{|}~_`abcdefghijklmnopqrstuvwxyz{|}~_`", :sortmethod, false},
        {"!🛅", :bitmethod, true},
        {"!🛅", :boolmethod, true},
        {"!🛅", :sortmethod, true},
        {"!🛅🛅", :bitmethod, false},
        {"!🛅🛅", :boolmethod, false},
        {"!🛅🛅", :sortmethod, false}
      ]
  end
end
