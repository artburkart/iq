defmodule ElixirCode.Chapter1Test.Problem2Test do
  use ExUnit.Case
  use ExUnit.Parameterized

  alias ElixirCode.Chapter1.Problem2, as: Problem2

  test_with_params "reverse_string",
    fn (str) ->
      (Problem2.reverse_string str) === (String.reverse str)
    end do
      printables = "0123456789abcdefghijklmnopqrstuvwx" <>
        "yzABCDEFGHIJKLMNOPQRSTUVWXYZ!\"#$%&\\\'()*+,-." <>
        "/:;<=>?@[\\\\]^_`{|}~ \\t\\n\\r\\x0b\\x0c"
        |> to_charlist
      Enum.reduce 0..9, [], (fn (_, acc) ->
        [{to_string (Enum.take_random printables, Enum.random 0..9)}|acc]
      end)
  end
end
