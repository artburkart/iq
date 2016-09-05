defmodule ElixirCode.Chapter1.Problem1 do
  @moduledoc """
    Implement an algorithm to determine if a string has all unique characters.
    What if you can not use additional data structures?
  """
  use Bitwise

  @compile :no_native

  @doc """
  Creates binary mask, then returns `true` if redundant characters are
  present, otherwise `false`.

  O(n): iterates through characters once

  ## Examples

    iex> bitmethod("aba")
    false

  """
  @spec bitmethod(String.t) :: boolean
  def bitmethod(str) when (is_bitstring str) and str == "", do: false
  def bitmethod(str) when (is_bitstring str), do: _bitmethod str, 0

  @spec _bitmethod(String.t, binary) :: boolean
  defp _bitmethod(<<>>, _), do: true
  defp _bitmethod(<<h::utf8, t::binary>>, mask) do
    marker = 1 <<< h
    cond do
      (marker &&& mask) > 0 -> false
      true -> _bitmethod t, (mask ||| marker)
    end
  end

  @doc """
  Creates boolean mask, then returns `true` if redundant characters are
  present, otherwise `false`

  O(n): iterates through length of string twice

  ## Examples

    iex> boolmethod("aba")
    false

  """
  @spec boolmethod(String.t) :: boolean
  def boolmethod(str) when (is_bitstring str) and str == "", do: false
  def boolmethod(str) when (is_bitstring str) do
    charlist = to_charlist str
    _boolmethod charlist, (for _ <-0..(Enum.max charlist), do: false)
  end

  @spec _boolmethod(list, list) :: boolean
  defp _boolmethod([], _), do: true
  defp _boolmethod([h|t], mask) do
    cond do
      (Enum.at mask, h) -> false
      true -> _boolmethod t, (List.replace_at mask, h, true)
    end
  end

  @doc """
  Sorts string, then returns `true` if redundant characters are present,
  otherwise `false`

  O(n log n): sorts array with merge sort

  ## Examples

    iex> sortmethod("aba")
    false

  """
  @spec sortmethod(String.t) :: boolean
  def sortmethod(str) when (is_bitstring str) and str == "", do: false
  def sortmethod(str) when (is_bitstring str), do: _sortmethod(Enum.sort to_charlist str)

  @spec _sortmethod(list) :: boolean
  defp _sortmethod(charlist) do
    case charlist do
      [h1,h2  |t] -> if (h1 == h2), do: false, else: _sortmethod([h2|t])
      _ -> true
    end
  end
end
