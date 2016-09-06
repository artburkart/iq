defmodule ElixirCode.Chapter1Test.Problem3Test do
  use ExUnit.Case
  use ExUnit.Parameterized

  alias ElixirCode.Chapter1.Problem3, as: Problem3

  test_with_params "is_permutation",
    fn (str_a, str_b, expected) ->
      assert (Problem3.is_permutation str_a, str_b) == expected
    end do
      [
        {"aba", "baa", true},
        {"aaa", "aaa", true},
        {"", "", true},
        {"a", "a", true},
        {"aab", "baa", true},
        {"aabc", "baac", true},
        {"ab", "cb", false},
        {"aaba", "aab", false},
        {"bbb", "aaa", false}
      ]
  end
end
